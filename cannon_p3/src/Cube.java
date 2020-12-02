
package COP3330_cannon.cannon_p3.src;

public class Cube extends Shape3D{
    private double side;
    //private String name;

    public Cube(double side) {
        this.side = side;

    }
    public double getSide() {
        return side;
    }
    /*public void setSide() {
        this.side = side;
    }*/

    public void setLength(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return (6*Math.pow(side, 2));
    }

    @Override
    public double getVolume() {
        return Math.pow(side, 3);
    }

    @Override
    public String getName() {
        return "cube";
    }
}
