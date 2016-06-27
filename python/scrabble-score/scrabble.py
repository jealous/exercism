# coding=utf-8
__author__ = 'Cedric Zhuang'

_score_map = {
    'aeioulnrst': 1,
    'dg': 2,
    'bcmp': 3,
    'fhvwy': 4,
    'k': 5,
    'jx': 8,
    'qz': 10
}

SCORE_MAP = {char: score
             for (letters, score) in _score_map.items()
             for char in letters}


def score(word):
    if not word.isalpha():
        word = ''

    return sum(map(SCORE_MAP.get, word.lower()))
