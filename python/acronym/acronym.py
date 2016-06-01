# coding=utf-8
from __future__ import unicode_literals

import re

__author__ = 'Cedric Zhuang'


def abbreviate(full):
    arr = re.findall(r'[A-Z]+[a-z]*|[a-z]+', full)
    return ''.join(map(lambda x: x[0], arr)).upper()
