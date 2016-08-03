from functools import reduce
from operator import mul

__author__ = 'Cedric Zhuang'


def largest_product(sequence, length):
    groups = slices(sequence, length)
    return max((reduce(mul, group, 1) for group in groups))


def slices(sequence, length):
    slen = len(sequence)
    if length > slen or slen > length == 0:
        raise ValueError()
    ints = list(map(int, list(sequence)))
    return [ints[index:index + length]
            for index in range(len(ints) - length + 1)]
