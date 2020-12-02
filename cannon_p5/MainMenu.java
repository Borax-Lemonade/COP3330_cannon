package COP3330_cannon.cannon_p5;

import java.util.Scanner;

public class MainMenu {

    static Scanner input = new Scanner(System.in);

    public static void selectApplication() {
        int choice = 0;
        do {
            System.out.println("Select Your Application\n" +
                    "-----------------------\n" +
                    "\n" +
                    "1) task lists\n" +
                    "2) contact list\n" +
                    "3) quit\n");
            try {
                choice = Integer.parseInt(input.next());
                //break;
            } catch (Exception ex) {
                System.out.println("Enter a valid int from 1-3");
            }
            switch (choice) {
                case 1:
                    TaskApp.mainMenu();
                    break;
                case 2:
                    ContactApp.mainMenu();
                    break;
                case 3:
                    System.out.println("Have an awful day :)");
                    System.exit(0);
                default:
                    System.out.println("Please enter an option 1-3.");
                    break;
            }

        }while(choice != 3);
    }
    public static void main(String[] args) {
        selectApplication();
    }
}
