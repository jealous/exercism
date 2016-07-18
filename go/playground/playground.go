package main

import (
	"fmt"
	"log"
	"net/url"
)

func main() {
	trailingSlash := "https://exercism.io/"
	noTrailingSlash := "https://exercism.io"

	ts, err := url.Parse(trailingSlash)
	if err != nil {
		log.Fatal(err)
	}

	ts.Path = "foo/bar/baz"
	fmt.Printf("ts without  / prefix: %s\n", ts)
	ts.Path = "/foo/bar/baz"
	fmt.Printf("ts with     / prefix: %s\n", ts)

	nts, err := url.Parse(noTrailingSlash)
	if err != nil {
		log.Fatal(err)
	}
	nts.Path = "foo/bar/baz"
	fmt.Printf("nts without / prefix: %s\n", nts)
	nts.Path = "/foo/bar/baz"
	fmt.Printf("nts with    / prefix: %s\n", nts)
}
