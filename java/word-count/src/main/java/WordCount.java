import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WordCount {
    private final Pattern pattern = Pattern.compile("\\b(\\w+)\\b");

    Map<String, Integer> phrase(String words) {
        Map<String, Integer> ret = new HashMap<>();
        Matcher matcher = pattern.matcher(words.toLowerCase());
        while (matcher.find()) {
            String word = matcher.group();
            ret.put(word, ret.getOrDefault(word, 0) + 1);
        }
        return ret;
    }
}
