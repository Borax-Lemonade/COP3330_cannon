public class Greeter {
    public static void main(String[] args) {
        // One way to get user input is as a program argument, but you have to rerun the program to get new input
        String prefix = args[0];

        System.out.println(prefix + ", world!");
    }
}
