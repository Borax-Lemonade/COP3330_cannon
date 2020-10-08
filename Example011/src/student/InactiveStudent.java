package student;

import gradebook.Assignment;

import java.util.ArrayList;

public class InactiveStudent extends Student {
    private String tinderId;
    private ArrayList<Assignment> assignments;

    private boolean enrolled;

    public InactiveStudent(String studentId, String tinderId, String name) {
        super(studentId, name);
        this.tinderId = tinderId;

        assignments = new ArrayList<>();

        enrolled = false;
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }
}
