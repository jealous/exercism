package secret

var actions = [...]string{
	"wink",
	"double blink",
	"close your eyes",
	"jump",
}

func Handshake(n int) []string {
	n %= 32
	if n <= 0 {
		return nil
	}

	r := make([]string, 0)
	j := 0
	for i := 1; j < 4; i = i << 1 {
		if n&i != 0 {
			r = append(r, actions[j])
		}
		j++
	}

	if n > 16 {
		reverse(&r)
	}
	return r
}

func reverse(p *[]string) *[]string {
	r := *p
	for i := len(r)/2 - 1; i >= 0; i-- {
		opp := len(r) - 1 - i
		r[i], r[opp] = r[opp], r[i]
	}
	return p
}
