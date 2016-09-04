import functools

__author__ = 'Cedric Zhuang'


def on_square(n):
    return 1 << (n - 1)


def total_after(n):
    return functools.reduce(lambda a, b: a | on_square(b), range(1, n + 1))
