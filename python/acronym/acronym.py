import re


def abbreviate(value):
    arr = re.findall(r'[A-Z]+[a-z]*|[a-z]+', value)
    return ''.join(word[0] for word in arr).upper()
