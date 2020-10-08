package gradebook;

import student.Student;

import java.util.ArrayList;

public class Gradebook {
    private final String courseName;
    private ArrayList<Student> students = new ArrayList<>();

    public Gradebook(String courseName) {
        this.courseName = courseName;
    }

    public void addAssignment(Assignment assignment) {

    }

    public void addStudent(Student student) {

    }

    public String getCourseName() {
        return this.courseName;
    }

    public Assignment getAssignmentByName(String s) {
        return null;
    }

    public Student getStudentById(String a12345678) {
        return null;
    }
}
