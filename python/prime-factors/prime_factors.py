__author__ = 'Cedric Zhuang'


def prime_factors(value):
    ret = []
    index = 0
    prime = Prime()
    while value != 1:
        p = prime[index]
        if value % p == 0:
            value /= p
            ret.append(p)
        else:
            index += 1
    return ret


class Prime(object):
    def __init__(self):
        self.cache = [2, 3, 5]

    def __getitem__(self, item):
        if item < len(self.cache):
            ret = self.cache[item]
        else:
            ret = self.next_prime()
        return ret

    def next_prime(self):
        value = self.cache[-1] + 2
        is_prime = False
        while True:
            for i in self.cache:
                if value % i == 0:
                    break
                elif i ** 2 > value:
                    is_prime = True
                    self.cache.append(value)
                    break
            if is_prime:
                break
            else:
                value += 2
        return value
