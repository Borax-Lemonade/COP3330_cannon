import java.util.Scanner;

// As programs grow more complicated, breaking them up into functions can improve readability

public class Greeter {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        greet();
    }

    public static void greet() {
        String prefix = "";
        while(!prefix.equalsIgnoreCase("goodbye")) {
            prefix = readGreeting();
            printGreeting(prefix);
        }
    }

    public static String readGreeting() {
        displayPrefixPrompt();
        return readPrefix();
    }

    public static void displayPrefixPrompt() {
        System.out.print("Prefix? ");
    }

    public static String readPrefix() {
        return in.nextLine();
    }

    public static void printGreeting(String prefix) {
        System.out.println(prefix + ", world!");
    }
}
