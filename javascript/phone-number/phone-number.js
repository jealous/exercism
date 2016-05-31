function PhoneNumber(number) {
    var arr = [];
    for (var c in number) {
        if (!isNaN(Number.parseInt(number[c]))) {
            arr.push(number[c]);
        }
    }

    if (arr.length === 11 && arr[0] === '1') {
        arr = arr.slice(1);
    }

    if (arr.length === 10) {
        this.n = arr.join('');
    } else {
        this.n = '0000000000';
    }
};

PhoneNumber.prototype.number = function() {
    return this.n;
};

PhoneNumber.prototype.areaCode = function() {
  return this.n.slice(0, 3);
}

PhoneNumber.prototype.toString = function() {
  return `(${this.areaCode()}) ${this.n.slice(3, 6)}-${this.n.slice(6)}`;
}

module.exports = PhoneNumber;
