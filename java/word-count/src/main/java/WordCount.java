import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class WordCount {
    private final Pattern pattern = Pattern.compile("[^\\w\\d]+");

    Map<String, Integer> phrase(String words) {

        return pattern.splitAsStream(words.toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.summingInt(v -> 1)));
    }
}
