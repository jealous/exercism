function sort(word) {
    return word.toLowerCase().split('').sort().join('');
}

function Anagram(sample) {
    this.origin = sample.toLowerCase();
    this.sorted = sort(sample);
};

Anagram.prototype.matches = function(items) {
    if (typeof items === 'string') {
        items = Array.prototype.slice.call(arguments);
    }

    return items.filter(item => {
        var i = item.toLowerCase();
        return this.sorted === sort(i) && this.origin !== i;
    });
};

module.exports = Anagram;
