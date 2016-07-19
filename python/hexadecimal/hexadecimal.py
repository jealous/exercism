# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'

_DICT = '0123456789abcdef'


def hexa(value):
    value = value.lower()
    if set(value) - set(_DICT):
        raise ValueError('not a valid hex number.')

    return sum(_DICT.index(c) << (4 * i)
               for i, c in enumerate(value[::-1]))
