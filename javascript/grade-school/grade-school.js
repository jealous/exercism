function School() {
    this.db = {};
};

School.prototype.roster = function() {
    return this.db;
};

School.prototype.add = function(name, grade) {
    names = this.db[grade] || [];
    names.push(name);
    this.db[grade] = names.sort();
};

School.prototype.grade = function(grade) {
    return this.db[grade] || [];
}

module.exports = School;
