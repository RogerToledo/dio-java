public class Square implements GeometricForm{
    private double side;

    public Square() {}

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }
}
