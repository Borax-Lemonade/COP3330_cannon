import java.util.InputMismatchException;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        while(true) {
            try {
                System.out.println("Enter a value for x: ");
                int x = scnr.nextInt();

                System.out.println("Enter a value for y: ");
                int y = scnr.nextInt();

                System.out.printf("%d / %d = %d", x, y, x / y);

                break;
            } catch (ArithmeticException ex) {
                System.out.println("You must enter a non-zero value for y.");
            } catch (InputMismatchException ex) {
                System.out.println("You must enter integer values.");
            } catch (Exception ex) {
                System.out.println("An unexpected error occured. Existing the program");
                System.exit(-1);
            } finally {
                scnr.nextLine();
            }
        }
    }
}