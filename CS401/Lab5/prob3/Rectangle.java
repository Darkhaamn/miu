package prob3;

public final class Rectangle implements Shape  {
    final double width;
    final double length;

    public Rectangle(double width, double length) {
        this.length = length;
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    @Override
    public double computeArea() {
        return width * length;
    }
}
