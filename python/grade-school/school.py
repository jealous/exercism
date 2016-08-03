from collections import defaultdict

__author__ = 'Cedric Zhuang'


class School(object):
    def __init__(self, school_name):
        self._school_name = school_name
        self._db = defaultdict(set)

    @property
    def db(self):
        return self._db

    def add(self, name, grade):
        self._db[grade].add(name)

    def grade(self, grade):
        return self.db[grade]

    def sort(self):
        for grade in sorted(self.db.keys()):
            yield (grade, tuple(sorted(self.db[grade])))
