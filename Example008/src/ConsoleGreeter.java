public class ConsoleGreeter extends Greeter {
    public ConsoleGreeter() {
        this("Hello");
    }

    public ConsoleGreeter(String prefix) {
        super(prefix);
    }

    public void greet() {
        System.out.println(this.getGreeting());
    }
}
