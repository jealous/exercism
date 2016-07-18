package bob

import "strings"

const testVersion = 2

func Hey(q string) (a string) {
	q = strings.TrimSpace(q)

	if len(q) == 0 {
		a = "Fine. Be that way!"
	} else if strings.ToUpper(q) == q && strings.ToLower(q) != strings.ToUpper(q) {
		a = "Whoa, chill out!"
	} else if q[len(q)-1] == '?' {
		a = "Sure."
	} else {
		a = "Whatever."
	}
	return
}
