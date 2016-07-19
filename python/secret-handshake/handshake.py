# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'

_dict = ['wink', 'double blink', 'close your eyes', 'jump']


def handshake(n):
    if not isinstance(n, int):
        try:
            n = int(n, 2)
        except ValueError:
            n = 0

    ret = []
    if 0 < n < 32:
        mask = 1
        for pos in range(4):
            if n & mask:
                ret.append(_dict[pos])
            mask <<= 1

        if n & mask:
            ret.reverse()

    return ret


def code(arr):
    last_index = None
    is_reverse = False
    ret = 0
    for action in arr:
        try:
            index = _dict.index(action)
        except ValueError:
            ret = 0
            break
        ret += 2 ** index
        if last_index is not None and last_index > index:
            is_reverse = True
        last_index = index
    if is_reverse:
        ret += 1 << 4
    return bin(ret)[2:]
