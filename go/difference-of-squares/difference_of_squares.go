package diffsquares

func SquareOfSums(n int) int {
	s := 0
	for i := 1; i <= n; i++ {
		s += i
	}
	return s * s
}

func SumOfSquares(n int) int {
	r := 0
	for i := 1; i <= n; i++ {
		r += i * i
	}
	return r
}

func Difference(n int) int {
	return SquareOfSums(n) - SumOfSquares(n)
}
