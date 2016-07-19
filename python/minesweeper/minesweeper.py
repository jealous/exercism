# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'


def _increment(mines, x, y):
    v = mines[x][y]
    u = None
    if v == ' ':
        u = '1'
    elif v.isdigit():
        u = str(int(v) + 1)

    if u is not None:
        mines[x] = mines[x][:y] + u + mines[x][y + 1:]


def board(mines):
    if len(set(map(len, mines))) > 1:
        raise ValueError('row length not align.')
    elif set(mines[0] + mines[-1]) - set('+-'):
        raise ValueError('invalid character in fence.')
    elif set(''.join(mines[1:-1])) - set(' *|'):
        raise ValueError('invalid character in field.')

    for i, row in enumerate(mines):
        for j, v in enumerate(row):
            if v == '*':
                [_increment(mines, x, y)
                 for x in range(i - 1, i + 2)
                 for y in range(j - 1, j + 2)]
    return mines
