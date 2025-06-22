import java.util.Scanner;

public class IMC {
    public void calcular() {
        var scanner = new Scanner(System.in);

        System.out.println("Digite seu peso e altura: ");

        var peso = scanner.nextDouble();
        var altura = scanner.nextDouble();

        var imc = peso / (altura * altura);

        if (imc <= 18.5) {
            System.out.printf("IMC = %.2f - Abaixo do peso!", imc);
        } else if (imc >= 18.6 && imc <= 24.9) {
            System.out.printf("IMC = %.2f -Peso ideal!", imc);
        } else if (imc >= 25.0 && imc <= 29.9) {
            System.out.printf("IMC = %.2f -Levemente acima do peso!", imc);
        } else if (imc >= 30.0 && imc <= 34.9) {
            System.out.printf("IMC = %.2f -Obesidade Grau I", imc);
        } else if (imc >= 35.0 && imc <= 39.9) {
            System.out.printf("IMC = %.2f -Obesidade Grau II (Severa)", imc);
        } else {
            System.out.printf("IMC = %.2f -Obesidade Grau III (Morbida)", imc);
        }
    }
}
