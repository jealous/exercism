package clock

import "fmt"

const (
	TestVersion = 1
	MAX_MINUTE  = 60
	MAX_HOUR    = 24
)

type Clock struct {
	h, m int
}

func New(hour, minute int) Clock {
	var c Clock = Clock{hour, minute}
	return c.normalize()
}

func (c *Clock) String() string {
	return fmt.Sprintf("%02v:%02v", c.h, c.m)
}

func (c Clock) Add(minute int) Clock {
	c.m += minute
	return c.normalize()
}

func (c *Clock) normalize() Clock {
	var b int
	b, c.m = toRange(c.m, MAX_MINUTE)
	c.h += b
	_, c.h = toRange(c.h, MAX_HOUR)
	return *c
}

func toRange(value int, max int) (int, int) {
	borrow := value / max
	value = value % max
	if value < 0 {
		borrow -= 1
		value += max
	}
	return borrow, value
}
