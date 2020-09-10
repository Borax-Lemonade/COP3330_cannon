public class Greeting {
    private String prefix;

    public Greeting() {
        this("Hello");
    }

    public Greeting(String prefix) {
        this.prefix = prefix;
    }

    public void greet() {
        throw new RuntimeException("greet() is not implemented in the base class.");
    }

    public String toString() {
        return prefix + ", world!";
    }
}
