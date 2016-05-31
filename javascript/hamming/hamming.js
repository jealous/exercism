function Hamming() {
    this.compute = function(left, right) {
        if (left.length != right.length) {
            throw new Error('DNA strands must be of equal length.');
        }

        return left.split('').reduce(function(prev, input, index) {
            return prev + (input != right[index]);
        }, 0)
    }
}

module.exports = Hamming;
