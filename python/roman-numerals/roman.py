__author__ = 'Cedric Zhuang'


dictionary = {
    1: ['X', 'V', 'I'],
    10: ['C', 'L', 'X'],
    100: ['M', 'D', 'C'],
    1000: ['', '', 'M']
}


def get_roman(value, position):
    ten, five, one = dictionary[position]
    roman = ''
    if value == 10:
        roman = ten
    elif value == 9:
        roman = one + ten
    else:
        if value >= 5:
            value -= 5
            roman += five
        if value <= 3:
            roman += one * value
        elif value == 4:
            roman += one + five
    return roman


def numeral(arabic):
    roman = ''
    positions = [p for p in dictionary.keys() if p <= arabic]
    for position in sorted(positions, reverse=True):
        value = arabic % (position * 10) / position
        roman += get_roman(value, position)
    return roman
