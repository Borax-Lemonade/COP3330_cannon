import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class FileExample {
    // Write a program that allows the user to enter in a student name and that student's grade
    // and then stores that data in a file.

    /*  User Scenario

    Bob starts the program and is presented with a prompt asking if he wants to enter student information.
    If bob selects `yes`, then the program prompts him for a student name and a student grade.
    After bob has entered the information, the program asks if he wishes to enter additional information.
    Bob will continue to enter information until he tells the program that he is done.
    When bob finishes entering information, the program writes all of the data to a file.

     */

    private static Scanner input = new Scanner(System.in);

    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> grades = new ArrayList<>();

    public static void main(String[] args) {
        FileExample m = new FileExample();
        m.processStudentGrades();
    }

    public void processStudentGrades() {
        String continueResponse = askShouldContinue();
        while(shouldContinue(continueResponse)) {
            String name = getStudentName();
            String grade = getStudentGrade();

            storeStudentInfo(name, grade);
            continueResponse = askShouldContinue();
        }

        writeStudentData(names, grades);
    }

    public boolean shouldContinue(String userInput) {
        return userInput.toLowerCase().startsWith("y");
    }

    public void writeStudentData(ArrayList<String> names, ArrayList<String> grades) {
        try(Formatter output = new Formatter("studentData.txt")) {
            for(int i = 0; i < names.size(); i++) {
                output.format("%s;%s", names.get(i), grades.get(i));
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void storeStudentInfo(String name, String grade) {
        names.add(name);
        grades.add(grade);
    }

    public String getStudentGrade() {
        // ask the user to enter a student name until they enter a valid name
        String grade = "";
        while(true) {
            System.out.println("Enter the student's grades:");
            grade = input.nextLine();

            // valid grades are A, B, C, D, F
            if(isGradeValid(grade)) {
                break;
            }
        }

        return grade;
    }

    public boolean isGradeValid(String grade) {
        return grade.equalsIgnoreCase("A") ||
                grade.equalsIgnoreCase("B") ||
                grade.equalsIgnoreCase("C") ||
                grade.equalsIgnoreCase("D") ||
                grade.equalsIgnoreCase("F");
    }

    public String getStudentName() {
        // ask the user to enter a student name until they enter a valid name
        String name = "";
        while(true) {
            System.out.println("Enter the student's name:");
            name = input.nextLine();

            // names are invalid if they are empty
            if(isNameValid(name)) {
                break;
            }
        }
        return name;
    }

    public boolean isNameValid(String name) {
        return name.length() > 0;
    }

    public static String askShouldContinue() {
        System.out.println("Do you wish to enter student information? (y/n):");
        return input.nextLine();
    }

    // Write a program that allows the user to read in a file of student names and grades and
    // displays that information to the console.
}
