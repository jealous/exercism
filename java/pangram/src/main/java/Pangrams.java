import java.util.stream.Collectors;

/**
 * @author Cedric Zhuang
 */
class Pangrams {
    static boolean isPangram(String s) {
        return s.toLowerCase().chars()
                .filter(c -> c >= 'a' && c <= 'z')
                .boxed()
                .collect(Collectors.toSet()).size() == 26;
    }
}

