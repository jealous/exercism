public class HelloWorld {
    static String hello(String name) {
        if (name == null || name.length() == 0) {
            name = "World";
        }
        return String.format("Hello, %s!", name);
    }
}
