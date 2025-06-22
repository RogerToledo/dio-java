import java.util.Scanner;

public class Tabuada {
    public void imprimir() {
        var scanner = new Scanner(System.in);
        System.out.println("Digite o número referênte a tabuada desejada: ");

        var num = scanner.nextInt();
        for (var i = 0; i <= 10; i++) {
            var result = i * num;
            System.out.printf("%d x %d = %d\n", i, num, result);
        }
    }
}
