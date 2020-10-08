package student;

import java.util.ArrayList;

import gradebook.Assignment;

public class ActiveStudent extends Student {
    private String tinderId;
    private ArrayList<Assignment> assignments;

    private boolean enrolled;

    public ActiveStudent(String studentId, String tinderId, String name) {
        super(studentId, name);
        this.tinderId = tinderId;

        assignments = new ArrayList<>();

        this.enrolled = true;
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }
}
