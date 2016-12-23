# coding=utf-8
from __future__ import unicode_literals
import operator

__author__ = 'Cedric Zhuang'

_OPERATOR_MAP = {
    'plus': operator.add,
    'minus': operator.sub,
    'multiplied': operator.mul,
    'divided': operator.truediv
}


def calculate(q):
    digits = []
    ops = []
    for word in q[:-1].split():
        try:
            digits.append(int(word))
        except ValueError:
            if word in _OPERATOR_MAP:
                ops.append(_OPERATOR_MAP[word])

    if len(digits) != len(ops) + 1:
        raise ValueError('invalid wordy.')

    digits.reverse()
    ops.reverse()
    while ops:
        digits.append(ops.pop()(digits.pop(), digits.pop()))

    return digits[0]
