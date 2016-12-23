from collections import defaultdict


class School(object):
    def __init__(self, name):
        self.name = name
        self._db = defaultdict(set)

    @property
    def db(self):
        return self._db

    def add(self, name, grade):
        names = self.db[grade]
        names.add(name)

    def grade(self, grade_no):
        return self.db[grade_no]

    def sort(self):
        return ((grade, tuple(sorted(list(self.db[grade]))))
                for grade in sorted(self.db.keys()))
