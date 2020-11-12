public class App {
    public static void main(String[] args) {
        // Beyond functions, we can abstract our programs to Objects
        Greeter greeter1 = new Greeter();
        greeter1.greet();

        Greeter greeter2 = new Greeter("Welcome");
        greeter2.greet();

        Greeter greeter3 = new Greeter("Greetings");
        greeter3.greet();

        greeter1.greet();
        greeter2.greet();
        greeter3.greet();
    }
}
