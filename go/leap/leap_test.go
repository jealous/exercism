package leap

import (
	"testing"
)

func TestLeapYears(t *testing.T) {
	for _, test := range testCases {
		observed := IsLeapYear(test.year)
		if observed != test.expected {
			t.Fatalf("IsLeapYear(%d) = %t, want %t (%s)",
				test.year, observed, test.expected, test.description)
		}
	}
}

func BenchmarkLeapYears(b *testing.B) {
	for i := 0; i < b.N; i++ {
		for _, test := range testCases {
			IsLeapYear(test.year)
		}
	}
}
