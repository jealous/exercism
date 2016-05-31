function Words() {
    this.count = function(s) {
        return s.trim().toLowerCase().split(/\s+/)
            .reduce((p, x) => {
                p[x] = (p[x] | 0) + 1;
                return p;
            }, {});
    }
};

module.exports = Words;
