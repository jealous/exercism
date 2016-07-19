# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'


_MATCH = dict(zip('}])', '{[('))


def check_brackets(value):
    stack = []
    for char in value:
        if char in _MATCH.values():
            stack.append(char)
            continue
        elif stack and stack.pop() == _MATCH.get(char):
            continue
        else:
            ret = False
            break
    else:
        ret = not stack
    return ret
