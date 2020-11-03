public class Rectangle implements Shape {
    double length;
    double width;
    String color;

    public Rectangle(double length, double width, String color) {
        this.length = length;
        this.width = width;
        this.color = color;
    }

    @Override
    public double area() {
        return this.length * this.width;
    }

    @Override
    public double perimeter() {
        return 2 * length + 2 * width;
    }

    @Override
    public String getColor() {
        return this.color;
    }
}
