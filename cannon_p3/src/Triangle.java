public class Triangle extends Shape2D{
    private double base, height;
    //private String name;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;

    }
    public double getBase() {
        return base;
    }
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return (getBase()*getHeight())/2;
    }

    @Override
    public String getName() {
        return "triangle";
    }
}
