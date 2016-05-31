function Isogram(str) {
    this.values = str.toLowerCase().match(/\w/g);
}

Isogram.prototype.isIsogram = function() {
    return this.values.length === new Set(this.values).size;
};

module.exports = Isogram
