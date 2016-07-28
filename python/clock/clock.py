# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'


class Clock(object):
    def __init__(self, hour, minute):
        self.hour = hour
        self.minute = minute

    def __str__(self):
        self.hour = (self.hour + self.minute // 60) % 24
        self.minute %= 60
        return '{:02}:{:02}'.format(self.hour, self.minute)

    def __eq__(self, other):
        return str(self) == str(other)

    def add(self, minute):
        self.minute += minute
        return self
