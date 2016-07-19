# coding=utf-8
from __future__ import unicode_literals
import operator

__author__ = 'Cedric Zhuang'


def _palindrome(max_factor, min_factor, op):
    value = None
    factors = []
    for i in range(min_factor, max_factor + 1):
        for j in range(i, max_factor + 1):
            v = i * j
            if value is None or op(v, value):
                s_v = str(v)
                if s_v[::-1] == s_v:
                    value = v
                    factors = [i, j]
    return value, factors


def smallest_palindrome(max_factor, min_factor):
    return _palindrome(max_factor, min_factor, operator.lt)


def largest_palindrome(max_factor, min_factor=1):
    return _palindrome(max_factor, min_factor, operator.gt)
