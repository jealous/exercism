# coding=utf-8
from __future__ import unicode_literals
import math

__author__ = 'Cedric Zhuang'


def primitive_triplets(n):
    mns = mn_from_b(n)
    ret = set()
    for m, n in mns:
        if (m - n) % 2 == 0 or not is_coprime(m, n):
            continue

        m2 = m ** 2
        n2 = n ** 2
        ret.add(tuple(sorted([m2 - n2, 2 * m * n, m2 + n2])))
    return ret


def triplets_in_range(start, end):
    base = set()
    for n in range(0, end + 1, 2):
        abc_set = primitive_triplets(n)
        base = base.union(filter(lambda abc: abc[-1] <= end, abc_set))

    ret = set()
    for a, b, c in base:
        for i in range(1, end / c + 1):
            if i * a >= start:
                ret.add((i * a, i * b, i * c))
    return ret


def is_triplet(t):
    a, b, c = sorted(t)
    return a ** 2 + b ** 2 == c ** 2


def is_coprime(a, b):
    if a < b:
        a, b = b, a

    r = a % b

    if b == 1:
        ret = True
    elif r == 0:
        ret = False
    elif r == 1:
        ret = True
    else:
        ret = is_coprime(r, b)
    return ret


def mn_from_b(b):
    if b % 2 == 1:
        raise ValueError('b should not be odd.')

    ret = set()
    mn = b / 2
    for n in range(1, int(math.ceil(math.sqrt(mn)))):
        m, mod = divmod(mn, n)
        if mod == 0:
            ret.add((m, n))
    return ret
