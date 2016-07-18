package hamming

import "errors"

const testVersion = 4

func Distance(a, b string) (diff int, err error) {
	if len(a) != len(b) {
		diff = -1
		err = errors.New("string size not match.")
	} else {
		for i := 0; i < len(a); i++ {
			if b[i] != a[i] {
				diff++
			}
		}
	}

	return
}
