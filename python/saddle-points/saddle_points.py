# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'


def saddle_points(arr):
    if len(set(map(len, arr))) > 1:
        raise ValueError('invalid matrix.')

    arr_t = zip(*arr)
    row_max = [max(row) for row in arr]
    col_min = [min(col) for col in arr_t]

    return {(i, j)
            for i, row in enumerate(arr)
            for j, value in enumerate(row)
            if value == row_max[i] and value == col_min[j]}
