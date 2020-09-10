public class Greeter {
    private String prefix;

    public Greeter() {
        this("Hello");
    }

    public Greeter(String prefix) {
        this.prefix = prefix;
    }

    public String getGreeting() {
        return this.prefix + ", world!";
    }

    public void greet() {
        throw new RuntimeException("Not implemented in base class.");
    }
}
