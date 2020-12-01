package COP3330_cannon.cannon_p5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskApp {

    private static Scanner input = new Scanner(System.in);

    public static TaskList listOfTasks;

    public TaskApp() {

    }

    public static void createNewList() {
        listOfTasks = new TaskList();
    }

    public static void loadNewList() {
        listOfTasks = new TaskList();
        readTasks();
    }

    private static void readTasks() {
        String fileName;
        //input.next();
        System.out.println("Enter file would you like to import tasks from");
        input.nextLine();
        fileName = input.nextLine();
        while(true) {
            try {
                Scanner fileInput = new Scanner(Paths.get(fileName));
                listOfTasks.readFile(fileName);
                break;
            } catch (IOException | NoSuchElementException |
                    IllegalStateException e) {
                System.out.println("input proper file name.");
                fileName = input.nextLine();
            }
        }
    }
    private static void processTaskMenu() {
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
                    "5) mark an item as completed\n" +
                    "6) unmark an item as completed\n" +
                    "7) save the current list\n" +
                    "8) quit to the main menu\n");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    listOfTasks.writeToConsole();
                    break;
                case 2:
                    input.nextLine();
                    listOfTasks.processTaskItems();
                    break;
                case 3:
                    listOfTasks.writeToConsole();
                    System.out.println("Which task would you like to edit?");
                    index = input.nextInt();
                    editTaskItem(index);
                    break;
                case 4:
                    listOfTasks.writeToConsole();
                    System.out.println("Which task would you like to remove?");
                    index = input.nextInt();
                    listOfTasks.remove(index);
                    break;
                case 5:
                    listOfTasks.writeToConsoleUncompletedTasks();

                    unmarkTaskItem();

                    break;
                case 6:
                    listOfTasks.writeToConsoleCompletedTasks();

                    markTaskItem();

                    break;
                case 7:
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
                    //listOfTasks.createFile(fileName);
                    listOfTasks.writeToFile(fileName);
                    break;
                case 8:
                    continueRunning = false;
                    break;

                default:

            }
        }
    }

    public static void unmarkTaskItem() {
        System.out.println("Which task would you like to mark as complete?");
        int index = input.nextInt();
        while (true) {
            try {
                listOfTasks.changeStatusToTrue(index);
                break;
            } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
                System.out.println("Enter valid index.");
                index = input.nextInt();
            }
        }

    }
    private static void markTaskItem() {
        System.out.println("Which task would you like to unmark as complete?");
        int index = input.nextInt();
        while (true) {
            try {
                listOfTasks.changeStatusToFalse(index);
                break;
            } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
                System.out.println("Enter valid index");
                index = input.nextInt();
            }
        }
    }


    public static TaskItem editTaskItem(int index) {
        TaskItem data = listOfTasks.get(index);
        TaskItem temp;
        input.nextLine();
        while(true) {
            try {
                System.out.println("Enter new task title");
                listOfTasks.get(index).setTitle(input.nextLine());
                System.out.println("Enter new task description");
                listOfTasks.get(index).setDescription(input.nextLine());
                System.out.println("Enter new task date(yyyy-mm-dd)");
                listOfTasks.get(index).setDate(input.nextLine());

                //temp = new TaskItem(title, description, date, isCompleted);
                break;
            } catch (InvalidTitleException ex) {
                System.out.println("Warning: task not created: Title must be at least one character ");
            } catch (PhoneNumberException ex) {
                System.out.println("Warning: task not created: Date must a valid yyyy-mm-dd");
            }
        }
        return data;
    }

    protected static String getTaskTitle() {
        String title;
        //input.nextLine();
        System.out.println("Enter task title");
        return input.nextLine();
    }

    protected static String getTaskDescription() {
        System.out.println("Enter task description");
        return input.nextLine();
    }

    protected static String getTaskDate() {
        System.out.println("Enter task date(yyyy-mm-dd)");
        return input.nextLine();
    }


    protected static Boolean getTaskIsCompleted() {
        return false;
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
                    createNewList();
                    processTaskMenu();
                    break;
                case 2:
                    loadNewList();
                    processTaskMenu();
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
        mainMenu();
    }
}