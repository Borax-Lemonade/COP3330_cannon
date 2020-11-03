public class App {
    public static void main(String[] args) {
        Square square = new Square(6, "red");
        Rectangle rect = new Rectangle(10, 5, "blue");

        printShapeInfo(square);
        printShapeInfo(rect);
    }

    public static void printShapeInfo(Shape s) {
        System.out.println(s.area());
        System.out.println(s.perimeter());
        System.out.println(s.getColor());
    }
}
