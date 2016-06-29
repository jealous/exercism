# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'

SUBLIST, SUPERLIST, EQUAL, UNEQUAL = (
    'SUBLIST', 'SUPERLIST', 'EQUAL', 'UNEQUAL')


def check_lists(l1, l2):
    ret = UNEQUAL

    if l1 == l2:
        ret = EQUAL
    elif _is_sublist(l1, l2):
        ret = SUBLIST
    elif _is_sublist(l2, l1):
        ret = SUPERLIST
    return ret


def _is_sublist(sub, full):
    sub_len = len(sub)
    full_len = len(full)

    ret = False
    if sub_len == 0:
        ret = True
    elif sub_len < full_len:
        for fi in xrange(full_len):
            # check first char before whole for perf concern
            if full[fi] == sub[0] and full[fi:fi + sub_len] == sub:
                ret = True
                break
    return ret
