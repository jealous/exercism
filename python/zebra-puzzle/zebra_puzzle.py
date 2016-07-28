# coding=utf-8
from __future__ import unicode_literals
import itertools

__author__ = 'Cedric Zhuang'

PEOPLE = ['Norwegian', 'Englishman', 'Spaniard', 'Ukrainian', 'Japanese']


def next_to(x, y):
    return abs(x - y) == 1


def right_to(x, y):
    return x - 1 == y


def solution():
    houses = first, _, middle, _, _ = range(5)
    p = list(itertools.permutations(houses))
    ans = next(
        (PEOPLE[water], PEOPLE[zebra])
        for (Norwegian, Englishman, Spaniard, Ukrainian, Japanese) in p
        if Norwegian == first
        for (green, red, ivory, yellow, blue) in p
        if Englishman == red and
        right_to(green, ivory) and
        next_to(Norwegian, blue)
        for (dog, snails, fox, horse, zebra) in p
        if Spaniard == dog
        for (coffee, tea, milk, orange_juice, water) in p
        if coffee == green and
        Ukrainian == tea and
        milk == middle
        for (old_gold, kools, chesterfields, lucky_strike, parliaments) in p
        if old_gold == snails and
        kools == yellow and
        next_to(chesterfields, fox) and
        next_to(kools, horse) and
        lucky_strike == orange_juice and
        Japanese == parliaments)

    return ("It is the {} who drinks the water.\n"
            "The {} keeps the zebra.").format(ans[0], ans[1])
