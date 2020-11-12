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

    private ArrayList<StudentData> studentData = new ArrayList<>();

    // the StudentDataManager is reponsible for writing student data to a file
    private StudentDataManager sdManager;

    public static void main(String[] args) {
        FileExample m = new FileExample();
        m.processStudentGrades();
    }

    public void processStudentGrades() {
        String continueResponse = askShouldContinue();
        while(shouldContinue(continueResponse)) {
            StudentData data = getStudentData();

            storeStudentData(data);
            continueResponse = askShouldContinue();
        }

        writeStudentData(studentData);
    }

    public boolean shouldContinue(String userInput) {
        return userInput.toLowerCase().startsWith("y");
    }

    public void writeStudentData(ArrayList<StudentData> studentData) {
        try(Formatter output = new Formatter("studentData.txt")) {
            for(int i = 0; i < studentData.size(); i++) {
                StudentData data = studentData.get(i);
                output.format("%s;%s%n", data.getName(), data.getGrade());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void storeStudentData(StudentData data) {
        studentData.add(data);
    }


    public StudentData getStudentData() {
        StudentData data = null;
        while(true) {
            try {
                String name = getStudentName();
                String grade = getStudentGrade();

                data = new StudentData(name, grade);
                break;
            } catch (InvalidNameException ex) {
                System.out.println("Warning: your name was invalid, please double check it and try again");
            } catch (InvalidGradeException ex) {
                System.out.println("Warning: your grade was invalid, please double check it and try again");
            }
        }
        return data;
    }

    public String getStudentName() {
        System.out.println("Enter the student's name:");
        return input.nextLine();
    }

    public String getStudentGrade() {
        System.out.println("Enter the student's grades:");
        return input.nextLine();
    }

    public static String askShouldContinue() {
        System.out.println("Do you wish to enter student information? (y/n):");
        return input.nextLine();
    }

    // Write a program that allows the user to read in a file of student names and grades and
    // displays that information to the console.
}
