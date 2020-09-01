import java.util.Scanner;

public class Greeter {
    public static void main(String[] args) {
        // A more typical way to get input from the user is with a Scanner object on the standard input stream
        Scanner in = new Scanner(System.in);

        // This has the benefit of allowing the program to prompt the user before getting input
        System.out.print("Prefix? ");
        String prefix = in.nextLine();

        System.out.println(prefix + ", world!");
    }
}
