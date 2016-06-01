# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'

ones = ('zero one two three four '
        'five six seven eight nine').split()

teens = ('ten eleven twelve thirteen fourteen '
         'fifteen sixteen seventeen eighteen nineteen').split()

tens = ('n/a n/a twenty thirty forty '
        'fifty sixty seventy eighty ninety').split()


def say(n):
    if n == 0:
        ret = ones[n]
    else:
        ret = _say(n)
    return ret.strip()


def _say(n, prefix=''):
    if n < 100 and prefix:
        ret = prefix
    else:
        ret = ''

    n = int(n)
    if n < 0:
        raise AttributeError('n must be a positive number.')
    elif n == 0:
        ret = ''
    elif n < 10:
        ret += ones[n]
    elif n < 20:
        ret += teens[n - 10]
    elif n < 100:
        ret += tens[n / 10] + _say(n % 10, '-')
    elif n < 1000:
        ret += _unit(n, 100, 'hundred')
    elif n < 1e6:
        ret = _unit(n, 1e3, 'thousand')
    elif n < 1e9:
        ret = _unit(n, 1e6, 'million')
    elif n < 1e12:
        ret = _unit(n, 1e9, 'billion')
    else:
        raise AttributeError('n must be less than or equal to 1e12.')
    return ret


def _unit(n, l, word):
    x, y = divmod(n, l)
    return '%s %s %s' % (_say(x), word, _say(y, 'and '))
