__author__ = 'Cedric Zhuang'


def transform(old):
    new = {}
    for k, v in old.iteritems():
        for i in v:
            new[i.lower()] = k
    return new
