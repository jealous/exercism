__author__ = 'Cedric Zhuang'


def on_square(n):
    return 1 << (n-1)


def total_after(n):
    return sum(on_square(i) for i in range(1, n+1))
