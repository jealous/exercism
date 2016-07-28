# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'

_CONTENT = ['the house ',
            'the malt\nthat lay in ',
            'the rat\nthat ate ',
            'the cat\nthat killed ',
            'the dog\nthat worried ',
            'the cow with the crumpled horn\nthat tossed ',
            'the maiden all forlorn\nthat milked ',
            'the man all tattered and torn\nthat kissed ',
            'the priest all shaven and shorn\nthat married ',
            'the rooster that crowed in the morn\nthat woke ',
            'the farmer sowing his corn\nthat kept ',
            'the horse and the hound and the horn\nthat belonged to ']


def verse(n):
    content = ''.join(_CONTENT[i] for i in range(n, -1, -1))
    return 'This is {}that Jack built.'.format(content)


def rhyme():
    return '\n\n'.join(map(verse, range(len(_CONTENT))))
