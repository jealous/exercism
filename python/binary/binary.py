# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'


def _ctob(c, i):
    if c == '1':
        ret = 1 << i
    elif c == '0':
        ret = 0
    else:
        raise ValueError('not a binary.')
    return ret


def parse_binary(b):
    return sum(_ctob(c, i) for i, c in enumerate(b[::-1]))
