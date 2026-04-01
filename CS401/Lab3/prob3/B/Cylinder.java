package lesson3.labs.prob3.B;

public class Cylinder  {
    private double height;
    private Circle circle;

    Cylinder(double radius, double height) {
//        super(radius);
        circle = new Circle(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double computeVolume() {
        return height * circle.computeArea();
    }
}
