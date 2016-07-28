# coding=utf-8
from __future__ import unicode_literals

from collections import Counter

__author__ = 'Cedric Zhuang'


def poker(hands):
    hands = map(Hand, hands)
    max_hand = max(hands)
    return [hand.hand for hand in hands if hand == max_hand]


class Hand(object):
    _MAP = dict((v, hex(i)[-1]) for i, v in enumerate('23456789TJQKA', 2))

    def __init__(self, hand):
        self.hand = hand
        self.nums = ''.join(sorted(self._MAP[card[0]] for card in hand))
        if self.nums == '2345e':
            # process straight A2345
            self.nums = '12345'
        self.num_counter = Counter(self.nums)

    def __cmp__(self, other):
        if not isinstance(other, Hand):
            raise ValueError('compare to same type only.')
        return cmp(self.key(), other.key())

    def key(self):
        return ''.join([self.straight_flush(),
                        self.squares(),
                        self.full(),
                        self.flush(),
                        self.straight(),
                        self.threes(),
                        self.doubles(),
                        self.ones()])

    def _with_counts(self, n, length=5):
        seq = [k for k, v in self.num_counter.items() if v == n]
        return '0' * (length - len(seq)) + ''.join(sorted(seq, reverse=True))

    def squares(self):
        return self._with_counts(4, 1)

    def threes(self):
        return self._with_counts(3, 1)

    def doubles(self):
        return self._with_counts(2, 2)

    def ones(self):
        return self._with_counts(1)

    def full(self):
        if self.doubles() != '00' and self.threes() != '0':
            ret = self.threes() + self.squares()
        else:
            ret = '000'
        return ret

    def _is_straight(self):
        items = len(self.num_counter.keys())
        nums = self.nums
        return items == 5 and int(nums[-1], 16) - int(nums[0], 16) == 4

    def straight(self):
        if self._is_straight():
            ret = self.nums[-1]
        else:
            ret = '0'
        return ret

    def _is_flush(self):
        return len(set(card[1] for card in self.hand)) == 1

    def flush(self):
        return '1' if self._is_flush() else '0'

    def straight_flush(self):
        return self.straight() if self._is_flush() else '0'
