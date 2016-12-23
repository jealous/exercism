import math


def encode(raw):
    raw = ''.join(i for i in raw.lower() if i.isalnum())
    c = int(math.ceil(len(raw) ** 0.5))
    return ' '.join(raw[i::c] for i in range(c))
