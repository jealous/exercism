# coding=utf-8


def is_pangram(s):
    return len(set(s.lower())) >= 27
