package triangle

import "math"

const testVersion = 2

func KindFromSides(a, b, c float64) Kind {
	var kind Kind
	if a+b < c || b+c < a || c+a < b ||
		!isValid(a) || !isValid(b) || !isValid(c) {
		kind = NaT
	} else if a == b && b == c {
		kind = Equ
	} else if a == b || b == c || c == a {
		kind = Iso
	} else {
		kind = Sca
	}
	return kind
}

func isValid(n float64) bool {
	return n != 0 && !math.IsInf(n, 0) && !math.IsNaN(n)
}

type Kind int

const (
	NaT = iota // not a triangle
	Equ        // equilateral
	Iso        // isosceles
	Sca        // scalene
)
