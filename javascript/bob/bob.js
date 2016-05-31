var Bob = function() {};

Bob.prototype.hey = function(input) {
    var ret;

    if (!input.trim()) {
        ret = 'Fine. Be that way!';
    } else if (input.toUpperCase() === input && input.toLowerCase() != input) {
        ret = 'Whoa, chill out!';
    } else if (input.endsWith('?')) {
        ret = 'Sure.';
    } else {
        ret = 'Whatever.';
    }

    return ret;
};

module.exports = Bob;
