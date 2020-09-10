public class ConsoleGreeter {
    private Greeting greeting;

    // Composition example; a ConsoleGreeter is "composed" of a Greeting
    public ConsoleGreeter(Greeting g) {
        greeting = g;
    }

    // This approach is okay because the object explicitly exists to greet using the console
    public void greet() {
        System.out.println(greeting);
    }
}
