function Pangram(value) {
    this.value = value;
};

Pangram.prototype.isPangram = function() {
    var value = this.value.toLowerCase().match(/[a-z]/g);
    return new Set(value).size >= 26;
};

module.exports = Pangram;
