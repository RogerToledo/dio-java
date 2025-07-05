import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Informe a operação (1-soma ou 2-subtração)");

        var operation = scanner.nextInt();
        while (operation > 2 || operation < 1) {
            System.out.println("Digite uma operação válida (1-soma ou 2-subtração)");
            operation = scanner.nextInt();
        }

        var selectedOperation = Operation.values()[operation - 1];

        System.out.println("Digite os números separados por vírgula (Ex.: 1,2,3,4)");
        var line = scanner.next();
        var arrayNumbers = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();

        var result = selectedOperation.getOperationBack().exec(arrayNumbers);

        if (operation == 1) {
            System.out.printf("O valor da soma é %d.", result);
        } else {
            System.out.printf("O valor da subtração é %d.", result);
        }
    }
}