/**
 * @author Cedric Zhuang
 */
public class PhoneNumber {

    private String number;

    PhoneNumber(String input) {
        number = filterNumbers(input);
        validate();
    }

    private void validate() {
        int size = number.length();
        if (size > 10 && !number.startsWith("1") || size < 10) {
            number = "0000000000";
        } else if (size == 11 && number.startsWith("1")) {
            number = number.substring(1);
        }
    }

    private static String filterNumbers(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    String getNumber() {
        return number;
    }

    String getAreaCode() {
        return number.substring(0, 3);
    }

    String pretty() {
        return String.format("(%s) %s-%s",
                getAreaCode(),
                number.substring(3, 6),
                number.substring(6));
    }
}
