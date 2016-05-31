__author__ = 'Cedric Zhuang'


class Luhn(object):
    def __init__(self, number):
        self.arr = map(int, str(number))

    @classmethod
    def create(cls, number):
        ret = number * 10
        luhn = Luhn(ret)
        to_add = (10 - luhn.checksum()) % 10
        return ret + to_add

    def addends(self):
        ret = self.arr[:]
        length = len(self.arr)
        for i in xrange(length-2, -1, -2):
            n = self.arr[i] * 2
            if n >= 10:
                n -= 9
            ret[i] = n
        return ret

    def checksum(self):
        return sum(self.addends()) % 10

    def is_valid(self):
        return self.checksum() == 0
