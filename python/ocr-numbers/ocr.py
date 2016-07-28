# coding=utf-8
from __future__ import unicode_literals
import string

__author__ = 'Cedric Zhuang'


def number(ocr):
    return ''.join(map(_single_number, _split_digits(ocr)))


def grid(num):
    if not num.isdigit():
        raise ValueError('invalid grid.')

    ocrs = (_TO_OCR[n] for n in num)
    return map(''.join, zip(*ocrs))


def _single_number(ocr):
    if len(ocr) != 4 or len(set(map(len, ocr))) != 1:
        raise ValueError('not valid OCR.')
    return _TO_NUM.get(tuple(ocr), '?')


def _split_digits(ocr):
    chunks = len(ocr[0]) // 3
    ocr = [[line[i * 3: i * 3 + 3]
            for i in range(chunks)]
           for line in ocr]
    ocr = zip(*ocr)
    return ocr


DIGITS = [' _     _  _     _  _  _  _  _ ',
          '| |  | _| _||_||_ |_   ||_||_|',
          '|_|  ||_  _|  | _||_|  ||_| _|',
          '                              ']

_TO_OCR = dict(zip(string.digits, _split_digits(DIGITS)))
_TO_NUM = {tuple(v): k for k, v in _TO_OCR.items()}
