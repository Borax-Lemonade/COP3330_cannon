public class Greeter {
    // Objects have state and behavior

    // Define the state (variables used in the class)
    private String prefix;

    // Constructors
    public Greeter() {
        this("Hello");
    }

    public Greeter(String p) {
        prefix = p;
    }

    // Methods
    public void greet() {
        System.out.println(prefix + ", world!");
        // The problem with this approach is that it will always print to the console when called.
    }
}
