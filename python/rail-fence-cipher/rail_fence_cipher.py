# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'


def encode(text, rails):
    ret = [[] for _ in range(rails)]
    delta = -1
    curr_rail = 0
    text = list(text)
    while text:
        ret[curr_rail].append(text.pop(0))
        if curr_rail == 0 or curr_rail == rails - 1:
            delta *= -1
        curr_rail += delta
    return ''.join(''.join(seq) for seq in ret)


def decode(text, rails):
    seq = _get_rail_sequences(text, rails)

    ret = []
    i = 0
    delta = -1
    while len(ret) < len(text):
        ret.append(seq[i].pop(0))
        if i == 0 or i == rails - 1:
            delta *= -1
        i += delta
    return ''.join(ret)


def _get_rail_sequences(text, rails):
    size = len(text)
    zigzag_len = rails * 2 - 2
    # get ceil of the divide result
    zigzag_list = [(size + zigzag_len - 1 - i) / zigzag_len
                   for i in range(zigzag_len)]
    seq = []
    offset = 0
    for i in range(rails):
        if i in {0, rails - 1}:
            rail_len = zigzag_list[i]
        else:
            rail_len = zigzag_list[i] + zigzag_list[(rails - 1) * 2 - i]
        seq.append(list(text[offset:offset + rail_len]))
        offset += rail_len
    return seq
