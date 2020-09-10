// Implicitly inherits from Object
public class Greeting {
    private String prefix;

    public Greeting() {
        this("Hello");
    }

    public Greeting(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return prefix + ", World!";
    }
}
