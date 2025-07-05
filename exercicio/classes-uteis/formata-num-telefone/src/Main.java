import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Digite o número do telefone ou celular");

        var number = scanner.next();
        var numberLength = number.length();

        while (numberLength > 11 || numberLength < 8) {
            System.out.println("Digite um número de telefone válido");
            number = scanner.next();
            numberLength = number.length();
        }

        switch (numberLength) {
            case 8 -> formatPhoneWithoutDDD(number);
            case 9 -> formatMobileWithoutDDD(number);
            case 10 -> formatPhoneWithDDD(number);
            case 11 -> formatMobileWithDDD(number);
            default -> System.out.println("Digite um número de telefone válido");
        }
    }

    private static void formatPhoneWithoutDDD(String number) {
        var isValid = validateNumber(number);
        if (!isValid) {
            System.out.println("Digite um número vádido!! Apenas NÚMEROS");
            return;
        }

        var firstPart = number.substring(0,4);
        var secondPart = number.substring(4,8);

        var formattedNumber = String.format("%s-%s", firstPart, secondPart);
        System.out.println(formattedNumber);
    }

    private static void formatPhoneWithDDD(String number) {
        var isValid = validateNumber(number);
        if (!isValid) {
            System.out.println("Digite um número vádido!! Apenas NÚMEROS");
            return;
        }

        var ddd = number.substring(0,2);
        var firstPart = number.substring(2,6);
        var secondPart = number.substring(6, 10);

        var formattedNumber = String.format("(%s) %s-%s", ddd, firstPart, secondPart);
        System.out.println(formattedNumber);
    }

    private static void formatMobileWithoutDDD(String number) {
        var isValid = validateNumber(number);
        if (!isValid) {
            System.out.println("Digite um número vádido!! Apenas NÚMEROS");
            return;
        }

        var firstPart = number.substring(0,5);
        var secondPart = number.substring(5,9);

        var formattedNumber = String.format("%s-%s", firstPart, secondPart);
        System.out.println(formattedNumber);
    }

    private static void formatMobileWithDDD(String number) {
        var isValid = validateNumber(number);
        if (!isValid) {
            System.out.println("Digite um número vádido!! Apenas NÚMEROS");
            return;
        }

        var ddd = number.substring(0,2);
        var firstPart = number.substring(2,7);
        var secondPart = number.substring(7, 11);

        var formattedNumber = String.format("(%s) %s-%s", ddd, firstPart, secondPart);
        System.out.println(formattedNumber);
    }

    private static boolean validateNumber(String number) {
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            };
        };

        return true;
    }
}