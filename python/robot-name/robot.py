# coding=utf-8
from __future__ import unicode_literals

import random
import string

__author__ = 'Cedric Zhuang'


class Robot(object):
    _generated_names = set()

    def __init__(self):
        self.name = None
        self.reset()

    def reset(self):
        while True:
            self.name = ''.join((self._sample_char(),
                                 self._sample_char(),
                                 self._sample_num(),
                                 self._sample_num(),
                                 self._sample_num()))
            if self.name in self._generated_names:
                continue
            else:
                self._generated_names.add(self.name)
                break

    @staticmethod
    def _sample_char():
        return random.choice(string.uppercase)

    @staticmethod
    def _sample_num():
        return random.choice(string.digits)
