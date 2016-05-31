# coding=utf-8
from __future__ import unicode_literals

import string

__author__ = 'Cedric Zhuang'

_uppers = string.ascii_uppercase
_lowers = string.ascii_lowercase


def abbreviate(full):
    arr = []

    for i, c in enumerate(full, 0):
        if i == 0:
            # first character
            arr.append(c)
        elif c in '- ':
            # word start
            arr.append(full[i + 1])
        elif c in _uppers and full[i - 1] in _lowers:
            # capital char after a lower char
            arr.append(c)
    return ''.join(arr).upper()
