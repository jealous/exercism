__author__ = 'Cedric Zhuang'


def transform(old):
    return {i.lower(): k
            for k, v in old.items()
            for i in v}
