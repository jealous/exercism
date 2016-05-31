# -*- coding: utf-8 -*-
#
# Skeleton file for the Python "Hello World" exercise.
#
from __future__ import unicode_literals


def hello(name=None):
    if name is None:
        name = 'World'
    return 'Hello, {}!'.format(name)
