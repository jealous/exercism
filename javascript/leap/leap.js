function Year(n) {
    this.n = n

    this.isLeap = function() {
        return (this.n % 4 == 0 && this.n % 100 != 0) || this.n % 400 == 0
    }
}

module.exports = Year;
