import java.util.HashMap;
import java.util.Map;

public class DNA {
    private Map<Character, Integer> dnaMap;

    DNA(String dna) {
        dnaMap = new HashMap<>();
        char[] nucleotideKinds = new char[]{'A', 'C', 'G', 'T'};

        for (char nucleotideKind : nucleotideKinds) {
            dnaMap.put(nucleotideKind, 0);
        }

        for (int i = 0; i < dna.length(); i++) {
            char key = dna.charAt(i);
            dnaMap.put(key, dnaMap.get(key) + 1);
        }
    }

    int count(char nucleotide) {
        if (!dnaMap.containsKey(nucleotide)) {
            throw new IllegalArgumentException(
                    String.format("%s is not a valid nucleotide.", nucleotide));
        }
        return dnaMap.get(nucleotide);
    }

    Map<Character, Integer> nucleotideCounts() {
        return dnaMap;
    }
}
