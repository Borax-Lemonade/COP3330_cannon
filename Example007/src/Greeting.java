public class Greeting {
    private String prefix;

    public Greeting() {
        this("Hello");
    }

    public Greeting(String prefix) {
        this.prefix = prefix;
    }

    public String toString() {
        return prefix + ", world!";
    }
}
