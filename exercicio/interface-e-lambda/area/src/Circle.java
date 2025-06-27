public class Circle implements GeometricForm {
    private final double pi = 3.14;
    private double radius;

    public Circle() {}

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return pi * (radius * radius);
    }
}
