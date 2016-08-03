import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author Cedric Zhuang
 */
public class Robot {
    private static final Random randGen = new Random();
    private static final Set<String> usedNames = new HashSet<>();
    private String name = "";

    Robot() {
        reset();
    }

    void reset() {
        char cName[] = new char[5];
        while (name.isEmpty() || usedNames.contains(name)) {
            cName[0] = rAlpha();
            cName[1] = rAlpha();
            cName[2] = rDigit();
            cName[3] = rDigit();
            cName[4] = rDigit();
            name = String.valueOf(cName);
        }
        usedNames.add(name);
    }

    String getName() {
        return name;
    }

    private char rChar(char start, int range) {
        return (char) ((int) start + randGen.nextInt(range));
    }

    private char rAlpha() {
        return rChar('A', 26);
    }

    private char rDigit() {
        return rChar('0', 10);
    }
}
