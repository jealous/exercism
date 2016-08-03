# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'


class Matrix(object):
    def __init__(self, raw):
        self.rows = [list(map(int, row.split()))
                     for row in raw.split('\n')]
        self.columns = list(map(list, zip(*self.rows)))
