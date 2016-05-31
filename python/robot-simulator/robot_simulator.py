# coding=utf-8
from __future__ import unicode_literals

__author__ = 'Cedric Zhuang'

EAST, SOUTH, WEST, NORTH = range(4)


class Robot(object):
    BEARINGS = {
        EAST: (1, 0),
        SOUTH: (0, -1),
        WEST: (-1, 0),
        NORTH: (0, 1)
    }

    def __init__(self, direction=NORTH, x=0, y=0):
        self.x = x
        self.y = y
        self.bearing = direction

        self.command_map = {
            'L': self.turn_left,
            'R': self.turn_right,
            'A': self.advance
        }

    @property
    def coordinates(self):
        return self.x, self.y

    def turn_right(self):
        self.bearing = (self.bearing + 1) % 4

    def turn_left(self):
        self.bearing = (self.bearing - 1) % 4

    def advance(self):
        self.x, self.y = map(sum, zip(self.BEARINGS[self.bearing],
                                      self.coordinates))

    def simulate(self, inputs):
        for i in inputs:
            self.command_map[i]()
