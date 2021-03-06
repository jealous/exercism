from functools import reduce

__author__ = 'Cedric Zhuang'


def square_of_sum(n):
    return reduce(lambda x, y: x + y, range(n + 1)) ** 2


def sum_of_squares(n):
    return sum(map(lambda x: x ** 2, range(n + 1)))


def difference(n):
    return abs(square_of_sum(n) - sum_of_squares(n))
