import java.util.stream.IntStream;

import static java.lang.Math.toIntExact;

public class Hamming {
    static int compute(String s1, String s2) {
        if (s1.length() != s2.length()) {
            throw new IllegalArgumentException("string length not equal.");
        }

        return toIntExact(IntStream.range(0, s1.length())
                .filter(i -> s1.charAt(i) != s2.charAt(i)).count());
    }
}
