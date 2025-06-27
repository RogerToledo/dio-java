public class Rectangle implements GeometricForm {
    private double height;
    private double base;

    public Rectangle() {}

    public Rectangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    @Override
    public double getArea() {
        return height * base;
    }
}
