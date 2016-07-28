# coding=utf-8
from __future__ import unicode_literals
import math

__author__ = 'Cedric Zhuang'


def is_perfect(n):
    divisors = {1}
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            divisors.add(i)
            divisors.add(n / i)
    return sum(divisors) == n
