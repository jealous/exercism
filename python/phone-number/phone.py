# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'


class Phone(object):
    def __init__(self, number):
        number = ''.join(c for c in number if c.isdigit())
        if len(number) == 11 and number[0] == '1':
            number = number[1:]

        if len(number) != 10:
            number = '0000000000'

        self.number = number

    def area_code(self):
        return self.number[0:3]

    def pretty(self):
        return '({}) {}-{}'.format(self.area_code(), self.number[3:6],
                                   self.number[6:])
