# coding=utf-8
from __future__ import unicode_literals

import functools

__author__ = 'Cedric Zhuang'


def next_cross(lines):
    return ((i, j) for i, line in enumerate(lines)
            for j, v in enumerate(line)
            if v == '+')


def is_connected(p1, p2, lines):
    x1, y1 = p1
    x2, y2 = p2
    ret = False
    if x1 == x2:
        if set(lines[x1][i] for i in range(y1, y2)).issubset({'+', '-'}):
            ret = True
    elif y1 == y2:
        if set(lines[i][y1] for i in range(x1, x2)).issubset({'+', '|'}):
            ret = True
    return ret


def count(lines=None):
    if not lines or not isinstance(lines, (tuple, list)):
        lines = []

    connected = functools.partial(is_connected, lines=lines)

    ret = 0
    for i, j in next_cross(lines):
        for x in range(i + 1, len(lines)):
            v = lines[x][j]
            if v == '|':
                continue
            elif v == '+':
                for y in range(j + 1, len(lines[i])):
                    v = lines[i][y]
                    if v == '-':
                        continue
                    elif v == '+':
                        if (lines[x][y] == '+' and
                                connected((x, j), (x, y)) and
                                connected((i, y), (x, y))):
                            ret += 1
                    else:
                        break
            else:
                break
    return ret
