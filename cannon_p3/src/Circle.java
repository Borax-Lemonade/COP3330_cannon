public class Circle extends Shape2D{
    private double radius;
    private String name;

    public Circle(double radius) {
        this.radius = radius;

    }
    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI*Math.pow(getRadius(),2);

    }

    @Override
    public String getName() {
        return "circle";
    }
}
