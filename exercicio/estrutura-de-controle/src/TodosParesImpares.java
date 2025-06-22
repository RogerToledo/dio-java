import java.util.Scanner;

public class TodosParesImpares {
    public void executa() {
        var scanner = new Scanner(System.in);

        System.out.println("Digite 2 números em que o segundo seja maior que o primeiro e escolha par ou impar: ");

        var num1 = scanner.nextInt();
        var num2 = scanner.nextInt();
        var op = scanner.next();

        if (num1 > num2) {
            System.out.println("O segundo número deve ser maior que o primiro");
        }

        for (var i = 0; i <= num2; i++) {
            var mod = i % 2;
            if (op.equalsIgnoreCase("par")) {
                if (mod == 0) {
                    System.out.println(i);
                }
            } else {
                if (mod != 0) {
                    System.out.println(i);
                }
            }
        }
    }
}
