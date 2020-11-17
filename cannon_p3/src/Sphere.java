public class Sphere extends Shape3D {
    private double radius;
    private String name;

    public Sphere(double radius) {
        this.radius = radius;

    }
    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return 4*Math.PI*Math.pow(getRadius(),2);
    }

    @Override
    public double getVolume() {
        return 4*Math.PI*Math.pow(getRadius(),3)/3;
    }

    @Override
    public String getName() {
        return "sphere";
    }
}
