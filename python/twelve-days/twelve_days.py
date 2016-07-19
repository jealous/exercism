# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'

_day = [('first', 'a Partridge in a Pear Tree.'),
        ('second', 'two Turtle Doves,'),
        ('third', 'three French Hens,'),
        ('fourth', 'four Calling Birds,'),
        ('fifth', 'five Gold Rings,'),
        ('sixth', 'six Geese-a-Laying,'),
        ('seventh', 'seven Swans-a-Swimming,'),
        ('eighth', 'eight Maids-a-Milking,'),
        ('ninth', 'nine Ladies Dancing,'),
        ('tenth', 'ten Lords-a-Leaping,'),
        ('eleventh', 'eleven Pipers Piping,'),
        ('twelfth', 'twelve Drummers Drumming,')]


def verse(n):
    items = ["On the {} day of Christmas my true "
             "love gave to me,".format(_day[n - 1][0])]
    for i in range(n, 0, -1):
        if i == 1 and n != 1:
            items.append('and')
        items.append(_day[i - 1][1])
    return ' '.join(items) + '\n'


def verses(start, end):
    return '\n'.join([verse(i) for i in range(start, end + 1)]) + '\n'


def sing():
    return verses(1, 12)
