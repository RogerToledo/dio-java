import java.util.Scanner;

public class CorporateEmailValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expectedDomain = "@company.com";
        String email = scanner.nextLine().trim();

        var validEmail = email.contains(expectedDomain);

        if (validEmail) {
            System.out.println("E-mail válido");
        } else {
            System.out.println("E-mail invalido");
        }

        scanner.close();
    }
}