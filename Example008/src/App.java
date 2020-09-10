public class App {
    public static void main(String[] args) {
        // Inheritance provides another way to build up one class based on another.
        Greeter g1 = new ConsoleGreeter("Salutations");
        g1.greet();
    }
}
