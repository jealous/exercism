# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'


def _find_next_prime():
    n = 3
    while True:
        root = int(n ** 0.5)
        for i in _primes:
            if n % i == 0:
                break
            elif i > root:
                _primes.append(n)
                yield len(_primes)
                break
        n += 2


_primes = [2]
_prime_gen = _find_next_prime()


def nth_prime(n):
    while next(_prime_gen) < n:
        pass
    return _primes[n - 1]
