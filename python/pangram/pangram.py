# coding=utf-8
import string


def is_pangram(s):
    return set(string.ascii_lowercase) - set(s.lower()) == set()
