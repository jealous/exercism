# coding=utf-8
from __future__ import unicode_literals


def encode(s):
    count = 0
    current = None
    arr = []
    for char in s + '\0':
        count += 1
        if char != current:
            if count > 1:
                arr.append(str(count))
            if current:
                arr.append(current)

            count = 0
            current = char
    return ''.join(arr)


def decode(s):
    count = ''
    arr = []
    for char in s:
        if char.isdigit():
            count += char
        else:
            if count:
                arr.append(char * int(count))
            else:
                arr.append(char)
            count = ''
    return ''.join(arr)
