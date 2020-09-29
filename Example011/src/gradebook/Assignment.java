package gradebook;

public class Assignment {
    private String name;
    private String dueDate;
    private double maxScore;
    private double studentScore;

    public Assignment(String name, String dueDate, double maxScore, double studentScore) {
        if(name.length() > 1) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("A name must be at least 2 characters.");
        }

        this.dueDate = dueDate;
        this.maxScore = maxScore;
        this.studentScore = studentScore;
    }

    public String getName() {
        return name;
    }

    public String getDueDate() {
        return dueDate;
    }

    public double getGrade() {
        return studentScore / maxScore;
    }
}
