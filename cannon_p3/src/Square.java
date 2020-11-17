public class Square extends Shape2D {

    private double side;
    private String name;

    public Square(double side) {
        this.side = side;

    }
    public double getSide() {
        return side;
    }

    public void setLength(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return Math.pow(getSide(), 2);
    }

    @Override
    public String getName() {
        return "square";
    }
}
