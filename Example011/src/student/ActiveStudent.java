package student;

import java.util.ArrayList;

import gradebook.Assignment;

public class ActiveStudent {
    private String studentId;
    private String tinderId;
    private String name;
    private ArrayList<Assignment> assignments;

    public ActiveStudent(String studentId, String tinderId, String name) {
        this.studentId = studentId;
        this.tinderId = tinderId;
        this.name = name;

        assignments = new ArrayList<>();
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }
}
