function Gigasecond (date) {
  this.milisecond = date.getTime();

  this.date = function() {
    return new Date(this.milisecond + 1e12);
  };
};

module.exports = Gigasecond;
