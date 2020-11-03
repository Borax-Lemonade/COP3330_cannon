public class Square implements Shape {
    double size;
    String color;

    public Square(double size, String color) {
        this.size = size;
        this.color = color;
    }

    @Override
    public double area() {
        return this.size * this.size;
    }

    @Override
    public double perimeter() {
        return 4 * size;
    }

    @Override
    public String getColor() {
        return this.color;
    }
}
