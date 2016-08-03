from string import ascii_lowercase
import re

__author__ = 'Cedric Zhuang'

alphabet = ascii_lowercase

cipher_key = dict(zip(alphabet, alphabet[::-1]))


def decode(s):
    s = re.sub('\s', '', s)
    return ''.join(map(lambda x: cipher_key.get(x, x), s))


def encode(s):
    s = s.lower()
    s = re.sub(r'[\s.,]', '', s)
    translated = ''.join(map(lambda x: cipher_key.get(x, x), s))
    return re.sub('(.{5})', '\g<0> ', translated).strip()
