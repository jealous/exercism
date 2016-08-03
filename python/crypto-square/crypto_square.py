# coding=utf-8
from __future__ import unicode_literals

import math
import string

__author__ = 'Cedric Zhuang'


def encode(raw):
    normalized = ''.join(
        filter(lambda c: c in string.digits + string.ascii_lowercase,
               raw.lower()))
    column = int(math.ceil(len(normalized) ** 0.5))
    return ' '.join(normalized[i::column] for i in range(column))
