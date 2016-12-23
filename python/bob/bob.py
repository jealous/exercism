# -*- coding: utf-8 -*-

def hey(what):
    what = what.strip()
    if len(what) == 0:
        ret = 'Fine. Be that way!'
    elif what.isupper():
        ret = 'Whoa, chill out!'
    elif what[-1] == '?':
        ret = 'Sure.'
    else:
        ret = 'Whatever.'
    return ret
