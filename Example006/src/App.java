public class App {

    public static void main(String[] args) {
        // The power of objects comes from how it enables abstraction in our code
        Greeting greeting1 = new Greeting();
        Greeting greeting2 = new Greeting("Welcome");
        Greeting greeting3 = new Greeting("Greetings");

        // Greeting objects automatically know how to respond when they're used as Strings; thus, we can think in terms
        // of "greetings" and not "strings that encode a greeting"
        System.out.println(greeting1);
        System.out.println(greeting2);
        System.out.println(greeting3);
    }

    // Show that a better way to "test" the Greeter object is with JUnit
}
