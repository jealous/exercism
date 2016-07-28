# coding=utf-8
import array

__author__ = 'Cedric Zhuang'


class BufferEmptyException(Exception):
    pass


class BufferFullException(Exception):
    pass


class CircularBuffer(object):
    def __init__(self, size):
        self._buf = array.array('c', [' '] * size)
        self._size = size
        self._start = 0
        self._used = 0

    def clear(self):
        self._used = 0

    def read(self):
        if self._used == 0:
            raise BufferEmptyException('buffer is empty.')

        ret = self._buf[self._start]
        self._start = (self._start + 1) % self._size
        self._used -= 1
        return ret

    def write(self, value):
        if self._used == self._size:
            raise BufferFullException('buffer is full')

        index = (self._start + self._used) % self._size
        self._buf[index] = value
        self._used += 1

    def overwrite(self, value):
        self._buf[self._start] = value
        self._start = (self._start + 1) % self._size
        if self._used < self._size:
            self._used += 1
