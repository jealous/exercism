function Robot() {
    this.reset();
};

Robot.prototype.reset = function() {
    while (true) {
        name = this.generateName();
        if (!this._names[name]) {
            this._names[name] = true;
            this.name = name;
            break;
        }
    }
}

Robot.prototype._names = {};

Robot.prototype.generateName = function() {
    return this.randomChar() + this.randomChar() + this.randomIntStr();
}

Robot.prototype.randomChar = function() {
    return String.fromCharCode(parseInt(Math.random() * 100) % 26 + 65);
};

Robot.prototype.randomIntStr = function() {
    s = '000' + parseInt(Math.random() * 1000).toString();
    return s.substr(s.length - 3);;
}

module.exports = Robot;
