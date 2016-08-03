__author__ = 'Cedric Zhuang'


def detect_anagrams(sample, words):
    anagram = Anagram(sample)
    return anagram.get_anagram(words)


class Anagram(object):
    def __init__(self, sample):
        self.sample = sample.upper()
        self.sorted_sample = sorted(self.sample)

    def get_anagram(self, words):
        return list(filter(self.is_anagram, words))

    def is_anagram(self, word):
        word = word.upper()
        return word != self.sample and self.sorted_sample == sorted(word)
