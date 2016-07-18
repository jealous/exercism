/**
 * @author Cedric Zhuang
 */
public class Bob {
    String hey(String s) {
        String ret;
        if (s.trim().isEmpty()) {
            ret = "Fine. Be that way!";
        } else if (s.toUpperCase().equals(s) && !s.toLowerCase().equals(s)) {
            ret = "Whoa, chill out!";
        } else if (s.endsWith("?")) {
            ret = "Sure.";
        } else {
            ret = "Whatever.";
        }
        return ret;
    }
}
