public class App {
    public static void main(String[] args) {
        Greeting g1 = new Greeting("Salutations");
        g1.greet();

        // Using objects also enables us to leverage "composition": building new objects using old objects as a base
        ConsoleGreeter cg = new ConsoleGreeter(g1);
        cg.greet();
    }
}
