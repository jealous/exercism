# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'


class TriangleError(Exception):
    pass


class Triangle(object):
    def __init__(self, a, b, c):
        a, b, c = sorted([a, b, c])
        if a + b <= c:
            raise TriangleError('invalid triangle.')

        if a == c:
            self._kind = "equilateral"
        elif a == b or b == c:
            self._kind = "isosceles"
        else:
            self._kind = "scalene"

    def kind(self):
        return self._kind
