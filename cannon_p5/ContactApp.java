package COP3330_cannon.cannon_p5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ContactApp {

    private static Scanner input = new Scanner(System.in);

    public static ContactList listOfContacts;

    public ContactApp() {

    }

    public static void createNewContactList() {
        listOfContacts = new ContactList();
    }

    public static void loadNewContactList() {
        listOfContacts = new ContactList();
        readContacts();
    }

    private static void readContacts() {
        String fileName;
        //input.next();
        System.out.println("Enter file would you like to import tasks from");
        input.nextLine();
        fileName = input.nextLine();
        while(true) {
            try {
                Scanner fileInput = new Scanner(Paths.get(fileName));
                listOfContacts.readFile(fileName);
                break;
            } catch (IOException | NoSuchElementException |
                    IllegalStateException e) {
                System.out.println("input proper file name.");
                fileName = input.nextLine();
            }
        }
    }

    private static void processContactMenu() {
        int choice , index;
        Boolean continueRunning = true;
        //choice = input.nextInt();
        while(continueRunning){
            System.out.println("\nList Operation Menu\n" +
                    "---------\n" +
                    "\n" +
                    "1) view the list\n" +
                    "2) add an item\n" +
                    "3) edit an item\n" +
                    "4) remove an item\n" +
                    "5) save the current list\n" +
                    "6) quit to the main menu\n");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    listOfContacts.writeToConsole();
                    break;
                case 2:
                    input.nextLine();
                    listOfContacts.processTaskItems();
                    break;
                case 3:
                    listOfContacts.writeToConsole();
                    System.out.println("Which task would you like to edit?");
                    index = input.nextInt();
                    editContactItem(index);
                    break;
                case 4:
                    listOfContacts.writeToConsole();
                    System.out.println("Which task would you like to remove?");
                    index = input.nextInt();
                    listOfContacts.remove(index);
                    break;
                case 5:
                    System.out.println("Enter file you would like to save to.");
                    String fileName = input.next();

                    while (true) {
                        try  {
                            File output = new File(fileName);
                            output.createNewFile();
                            break;
                        } catch (IOException e) {
                            System.out.println("Enter a valid text file to write to");
                        }
                    }
                    listOfContacts.writeToFile(fileName);
                    break;
                case 6:
                    continueRunning = false;
                    break;

                default:

            }
        }
    }

    public static ContactItem editContactItem(int index) {
        ContactItem data = listOfContacts.get(index);
        //ContactItem temp;
        input.nextLine();
        while(true) {
            try {
                System.out.println("Enter new first name");
                listOfContacts.get(index).setFirstName(input.nextLine());
                System.out.println("Enter new last name");
                listOfContacts.get(index).setLastName(input.nextLine());
                System.out.println("Enter new phone number(xxx-xxx-xxxx)");
                listOfContacts.get(index).setPhoneNumber(input.nextLine());
                System.out.println("Enter a new email.");
                listOfContacts.get(index).setEmail(input.nextLine());

                //temp = new TaskItem(title, description, date, isCompleted);
                break;
            } catch (InvalidNameException ex) {
                System.out.println("Warning: task not created: Title must be at least one character ");
            } catch (PhoneNumberException ex) {
                System.out.println("Warning: task not created: Date must a valid yyyy-mm-dd");
            }
        }
        return data;
    }

    public static String getContactEmail() {
        System.out.println("Enter email(x@y.z)");
        return input.nextLine();
    }

    public static String getContactNumber() {
        System.out.println("Enter phone number(xxx-xxx-xxxx)");
        return input.nextLine();
    }

    public static String getContactLastName() {
        System.out.println("Enter last name");
        return input.nextLine();
    }

    public static String getContactFirstName() {
        System.out.println("Enter first name");
        return input.nextLine();
    }

    public static void mainMenu() {
        int choice = 0;
        do {
            System.out.println("Main Menu\n" +
                    "---------\n" +
                    "\n" +
                    "1) create a new list\n" +
                    "2) load an existing list\n" +
                    "3) quit");
            try {
                choice = Integer.parseInt(input.next());
                //break;
            } catch (Exception ex) {
                System.out.println("Enter a valid int from 1-3");
            }
            switch (choice) {
                case 1:
                    createNewContactList();
                    processContactMenu();
                    break;
                case 2:
                    loadNewContactList();
                    processContactMenu();
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

}