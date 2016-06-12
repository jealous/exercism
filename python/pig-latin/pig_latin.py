# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'


def translate(value):
    return ' '.join(map(_do, value.split()))


_dictionary = (
    (['yt', 'xr'] + list('aeiou'),
     lambda value, prefix: value + 'ay'),
    ('squ thr sch thr ch qu th'.split() + list('bdfghkpqrtxy'),
     lambda value, prefix: value[len(prefix):] + prefix + 'ay')
)


def _do(value):
    for prefix, func in _dictionary:
        matched = list(filter(lambda i: value.startswith(i), prefix))
        if matched:
            ret = func(value, matched[0])
            break
    else:
        raise ValueError("don't know how to translate {}.".format(value))
    return ret
