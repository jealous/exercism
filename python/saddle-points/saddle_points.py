# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'


def _to_set(value_dict):
    ret = []
    for v in value_dict.values():
        ret += v
    return set(ret)


def saddle_points(arr):
    row_max = {}
    col_min = {}
    row_max_v = None
    col_min_v = {}
    row_size = None

    for row_i, row in enumerate(arr):
        if row_size is None:
            row_size = len(row)
        elif row_size != len(row):
            raise ValueError('not a valid array.')

        for col_i, v in enumerate(row):
            if row_max_v is None or v > row_max_v:
                row_max_v = v
                row_max[row_i] = [(row_i, col_i)]
            elif row_max_v == v:
                row_max[row_i].append((row_i, col_i))

            if col_min_v.get(col_i) is None or v < col_min_v.get(col_i):
                col_min_v[col_i] = v
                col_min[col_i] = [(row_i, col_i)]
            elif col_min_v.get(col_i) == v:
                col_min[col_i].append((row_i, col_i))

        row_max_v = None

    return _to_set(row_max).intersection(_to_set(col_min))
