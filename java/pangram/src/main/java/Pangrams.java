import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Cedric Zhuang
 */
public class Pangrams {
    public static boolean isPangram(String s) {
        // all chars including an empty is 27
        return Arrays.stream(s.toLowerCase().split(""))
                .collect(Collectors.toSet()).size() >= 27;
    }
}

