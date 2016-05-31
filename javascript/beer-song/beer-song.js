function BeerSong() {}

BeerSong.prototype.quant = function(value) {
    return value === 1 ? 'bottle' : 'bottles';
};

BeerSong.prototype.toStr = function(value) {
    return value === 0 ? 'no more' : value.toString();
};

BeerSong.prototype.cap = function(str) {
    return str.toString()[0].toUpperCase() + str.slice(1);
};

BeerSong.prototype.bottle = function(value) {
    return `${this.toStr(value)} ${this.quant(value)}`;
};

BeerSong.prototype.verse = function(value) {
    var first = this.first(value);
    var second = this.second(value);
    var third = this.third(value);
    var last = this.last(value);

    return `${first} ${second}\n${third} ${last}\n`;
};

BeerSong.prototype.sing = function(start, end) {
    var arr = [];
    var end = end | 0;
    for (var i = start; i >= end; i--) {
        arr.push(this.verse(i));
    }
    return arr.join('\n');
};

BeerSong.prototype.first = function(value) {
    return `${this.cap(this.bottle(value))} of beer on the wall,`;
};

BeerSong.prototype.second = function(value) {
    return `${this.bottle(value)} of beer.`;
};

BeerSong.prototype.third = function(value) {
    var ret;
    switch (value) {
        case 0:
            ret = 'Go to the store and buy some more,';
            break;
        case 1:
            ret = 'Take it down and pass it around,';
            break;
        default:
            ret = 'Take one down and pass it around,';
    }
    return ret;
};

BeerSong.prototype.last = function(value) {
    var next = value === 0 ? 99 : value - 1;
    return `${this.bottle(next)} of beer on the wall.`;
};

module.exports = BeerSong;
