# coding=utf-8
from __future__ import unicode_literals

import math
import string

__author__ = 'Cedric Zhuang'


def encode(raw):
    normalized = filter(lambda c: c in string.digits + string.lowercase,
                        raw.lower())
    column = int(math.ceil(math.sqrt(len(normalized))))
    return ' '.join(normalized[i::column] for i in range(0, column))
