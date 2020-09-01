import java.util.Scanner;

public class Greeter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // One major benefit of using a Scanner over program arguments is the ability to re-read input
        String greeting = "";
        while(!greeting.equalsIgnoreCase("goodbye")) {
            System.out.print("Prefix? ");
            greeting = in.nextLine();
            System.out.println(greeting + ", world!");
        }
    }
}
