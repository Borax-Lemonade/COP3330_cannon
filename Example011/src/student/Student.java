package student;

public class Student {
    private final String studentId;
    private final String name;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public String getId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}
