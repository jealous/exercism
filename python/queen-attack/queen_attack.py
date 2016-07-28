# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'


def _validate(white, black):
    if white == black:
        raise ValueError('white and black at the same point.')
    elif max(white) > 7 or max(black) > 7:
        raise ValueError('invalid point.')


def board(white, black):
    _validate(white, black)

    fill = {white: 'W', black: 'B'}
    return [''.join(fill.get((x, y), '_')
                    for y in range(8))
            for x in range(0, 8)]


def can_attack(white, black):
    _validate(white, black)

    dx, dy = abs(white[0] - black[0]), abs(white[1] - black[1])
    return dx == 0 or dy == 0 or dx == dy
