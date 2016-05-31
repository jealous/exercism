var HelloWorld = function() {};

HelloWorld.prototype.hello = function(input) {
    input = input || 'world';
    return `Hello, ${input}!`;
};

module.exports = HelloWorld;
