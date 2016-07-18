package gigasecond

import "time"

const TestVersion = 1

var Birthday = time.Date(1983, 11, 2, 9, 31, 0, 0, time.UTC)

func AddGigasecond(start time.Time) time.Time {
	return start.Add(1e9 * time.Second)
}
