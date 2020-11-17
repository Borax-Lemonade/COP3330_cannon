public class Pyramid extends Shape3D{
    private double length, width, height;

    public Pyramid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;

    }
    public double getLength() {
        return length;
    }
    public void setLength() {
        this.length = length;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth() {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight() {
        this.height = height;
    }


    @Override
    public double getArea() {
        return (getLength()*getWidth() + getWidth()*(Math.pow(Math.pow(getHeight(),2) + Math.pow((getLength()/2),2),.5)) +
                getLength()*(Math.pow(Math.pow(getHeight(),2) + Math.pow((getWidth()/2),2),.5)));
    }

    @Override
    public double getVolume() {
        return (getLength()*getWidth()*getHeight())/3;
    }

    @Override
    public String getName() {
        return "pyramid";
    }
}
