function FoodChain() {
    this._chain = ('fly, spider that wriggled and jiggled and tickled inside her, ' +
        'bird, cat, dog, goat, cow, horse').split(', ');
};

FoodChain.prototype.animal = function(line) {
    return this.chain(line).split(' ')[0];
};

FoodChain.prototype.chain = function(line) {
    return this._chain[line - 1];
}

FoodChain.prototype.first = function(line) {
    return `I know an old lady who swallowed a ${this.animal(line)}.\n`
}

FoodChain.prototype.second = function(line) {
    var arr = ['', '',
      'It wriggled and jiggled and tickled inside her.\n',
      'How absurd to swallow a bird!\n',
      'Imagine that, to swallow a cat!\n',
      'What a hog, to swallow a dog!\n',
      'Just opened her throat and swallowed a goat!\n',
      "I don't know how she swallowed a cow!\n",
      "She's dead, of course!\n"
    ];
    var ret;
    if (line < arr.length) {
      ret = arr[line];
    } else {
      ret = '';
    }
    return ret;
}

FoodChain.prototype.middle = function(line) {
    var ret = '';
    while (line > 1 && line < 8) {
        ret += `She swallowed the ${this.animal(line)} to catch ` +
            `the ${this.chain(line-1)}.\n`
        line -= 1;
    }
    return ret;
}

FoodChain.prototype.last = function(line) {
    var ret;
    if (line < 8) {
        ret = "I don't know why she swallowed the fly. Perhaps she'll die.\n";
    } else {
        ret = "";
    }
    return ret;
}

FoodChain.prototype.verse = function(line) {
    return [
        this.first(line),
        this.second(line),
        this.middle(line),
        this.last(line)
    ].join('');
};

FoodChain.prototype.verses = function(start, end) {
    var arr = [];
    while (start <= end) {
        arr.push(this.verse(start++));
    }
    arr.push('');
    return arr.join('\n');
};

module.exports = FoodChain;
