# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'


def _bottle(n):
    if n == 0:
        ret = 'no more bottles'
    elif n == 1:
        ret = '1 bottle'
    else:
        ret = '{} bottles'.format(n)
    return ret


def verse(n):
    curr = _bottle(n)
    prev = _bottle(n - 1)

    quan = 'it' if n == 1 else 'one'

    if n == 0:
        ret = (
            "No more bottles of beer on the wall, no more bottles of beer.\n"
            "Go to the store and buy some more, "
            "99 bottles of beer on the wall.\n")
    else:
        ret = (
            "{0} of beer on the wall, {0} of beer.\n"
            "Take {2} down and pass it around, "
            "{1} of beer on the wall.\n").format(curr, prev, quan)

    return ret


def song(start, end=0):
    v = range(end, start + 1)
    v.reverse()
    return '\n'.join(map(verse, v)) + '\n'
