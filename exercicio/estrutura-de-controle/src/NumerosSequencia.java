import java.util.Scanner;

public class NumerosSequencia {
    public void imprime() {
        var scanner = new Scanner(System.in);

        System.out.println("Digite um número inicial: ");
        var inicial = scanner.nextInt();

        while(true) {
            System.out.println("Digite um número na ordem crescente: ");
            var num = scanner.nextInt();

            if (num < inicial) {
                continue;
            }

            var mod = num % inicial;

            System.out.printf("%s mod %s = %s\n", num, inicial, mod);

            if (mod != 0) {
                break;
            }
        }

    }
}
