from datetime import timedelta

__author__ = 'Cedric Zhuang'


def add_gigasecond(start):
    return start + timedelta(seconds=10 ** 9)
