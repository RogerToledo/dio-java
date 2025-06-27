import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Selecione uma opção ===");
            System.out.println("0 - Sair");
            System.out.println("1 - Circulo");
            System.out.println("2 - Retangulo");
            System.out.println("3 - Quadrado");

            var option = scanner.nextInt();

            switch (option) {
                case 0 -> System.exit(-1);
                case 1 -> getCircleAre();
                case 2 -> getRectangleArea();
                case 3 -> getSquareArea();
            }
        }
    }

    public static void getCircleAre() {
        System.out.println("Digite o valor raio");
        var radius = scanner.nextDouble();

        var circle = new Circle(radius);

        var area = circle.getArea();

        System.out.printf("A área do circulo é %.2f\n", area);
    }

    public static void getRectangleArea() {
        System.out.println("Digite o valor da altura e da base");
        var height = scanner.nextDouble();
        var base = scanner.nextDouble();

        var rectangle = new Rectangle(height, base);

        var area = rectangle.getArea();

        System.out.printf("O área do retangulo é %.2f\n", area);
    }

    public static void getSquareArea() {
        System.out.println("Digite o valor do lado");
        var side = scanner.nextDouble();

        var square = new Square(side);

        var area = square.getArea();

        System.out.printf("A área do quadrado é %.2f\n", area);
    }
}

