__author__ = 'Cedric Zhuang'

from operator import mul


def largest_product(sequence, length):
    groups = slices(sequence, length)
    return max((reduce(mul, group, 1) for group in groups))


def slices(sequence, length):
    slen = len(sequence)
    if length > slen or slen > length == 0:
        raise ValueError()
    ints = map(int, list(sequence))
    return [ints[index:index + length]
            for index in xrange(len(ints) - length + 1)]
