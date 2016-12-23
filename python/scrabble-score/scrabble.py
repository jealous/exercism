score_mpa = {
    'aeioulnrst': 1,
    'dg': 2,
    'bcmp': 3,
    'fhvwy': 4,
    'k': 5,
    'jx': 8,
    'qz': 10,
}

SCORE_MAP = {c: v
             for k, v in score_mpa.items()
             for c in k}


def score(value):
    if not value.isalpha():
        value = ''
    return sum([SCORE_MAP[c] for c in value.lower()])
