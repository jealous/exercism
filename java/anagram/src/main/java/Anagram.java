import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Anagram {
    private String word;
    private String sortedWord;

    Anagram(String word) {
        this.word = word.toLowerCase();
        this.sortedWord = sort(this.word);
    }

    private static String sort(String orig) {
        char[] arr = orig.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    private boolean isMatch(String anagram) {
        anagram = anagram.toLowerCase();
        return sort(anagram).equals(sortedWord) && !anagram.equals(word);
    }

    List<String> match(Collection<String> words) {
        return words.stream()
                .filter(this::isMatch)
                .collect(Collectors.toList());
    }
}
