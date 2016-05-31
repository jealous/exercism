__author__ = 'Cedric Zhuang'


class SpaceAge(object):
    RATIO_MAP = {
        "earth": 1.0,
        "mercury": 0.2408467,
        "venus": 0.61519726,
        "mars": 1.8808158,
        "jupiter": 11.862615,
        "saturn": 29.447498,
        "uranus": 84.016846,
        "neptune": 164.79132
    }

    EARTH = 31557600

    def __init__(self, seconds):
        self.seconds = seconds

    def __getattr__(self, item):
        planet = ''
        if item.startswith('on_'):
            planet = item[3:]

        if planet in self.RATIO_MAP.keys():
            ratio = self.RATIO_MAP[planet]
            ret = lambda: round(self.seconds / ratio / self.EARTH, 2)
        else:
            raise NotImplementedError('attribute is not defined.')

        return ret
