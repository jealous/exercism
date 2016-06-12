# coding=utf-8
from __future__ import unicode_literals

import random
import string

import re

__author__ = 'Cedric Zhuang'

letters = string.ascii_lowercase


class Caesar(object):
    key = 'd' * 100

    def get_distance(self, i, is_encode=True):
        ret = ord(self.key[i % len(self.key)]) - ord('a')
        if not is_encode:
            ret = -ret
        return ret

    def translate(self, text, is_encode=True):
        arr = []
        for i, c in enumerate(text):
            if c not in letters:
                continue
            code = ord(c) + self.get_distance(i, is_encode)
            if code > ord('z'):
                code -= 26
            if code < ord('a'):
                code += 26
            arr.append(chr(code))

        return ''.join(arr)

    def encode(self, text):
        return self.translate(text.lower())

    def decode(self, text):
        return self.translate(text, False)


class Cipher(Caesar):
    def __init__(self, key=None):
        if key is None:
            key = self.random_key()
        if key.lower() != key or re.findall('[0-9]', key):
            raise ValueError('key should only contain lower case characters.')

        self.key = key

    @staticmethod
    def random_key():
        return ''.join(random.choice(letters) for _ in xrange(100))
