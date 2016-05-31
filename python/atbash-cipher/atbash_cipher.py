__author__ = 'Cedric Zhuang'

from string import maketrans
import re

alphabet = "abcdefghijklmnopqrstuvwxyz"

cipher_key = maketrans(alphabet, alphabet[::-1])


def decode(s):
    s = re.sub('\s', '', s)
    return s.translate(cipher_key)


def encode(s):
    s = s.lower()
    s = re.sub('[\s\.,]', '', s)
    translated = s.translate(cipher_key)
    return re.sub('(.{5})', '\g<0> ', translated).strip()
