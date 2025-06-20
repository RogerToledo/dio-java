import java.util.Scanner;

public class NumerosSequencia {
    public void NumeroSequencia() {
        var scanner = new Scanner(System.in);
        var mod = 0;
        var first = 0;
        var count = 0;

        do {
            System.out.println("Digite números decresente: ");
            if (count == 0) {
                first = scanner.nextInt();
            }
            var num = scanner.nextInt();
            if (num < first) {
                continue;
            }
            mod = num % first;
            count++;
        } while (mod == 0);

    }
}
