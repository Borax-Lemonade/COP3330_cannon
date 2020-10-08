package gradebook;

public class Assignment {
    private String name;
    private String dueDate;
    private double weight;
    private double maxScore;

    public Assignment(String name, String dueDate, double weight, double maxScore) {
        this.name = name;
        this.dueDate = dueDate;
        this.weight = weight;
        this.maxScore = maxScore;
    }

    public String getName() {
        return name;
    }

    public String getDueDate() {
        return dueDate;
    }

    public double getWeight() {
        return weight;
    }

    public double getMaxScore() {
        return maxScore;
    }
}
