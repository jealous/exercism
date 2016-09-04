package foodchain

import "strings"

const testVersion = 2

func Verse(at int) string {
	return ""
}

func Verses(from, to int) string {
	list := make([]string, to - from + 1)
	for i := from ; i <= to ; i ++ {
		list[i - 1] = Verse(i)
	}
	return strings.Join(list, "\n\n")
}

func Song() string {
	return Verses(1, 8)
}