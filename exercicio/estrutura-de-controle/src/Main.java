//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
           1 - Tabuada
           2 - IMC
           3 - Todos os pares ou impares
           4 - numeros sequencia
         */

        var exercicio = 1;

        switch (exercicio) {
            case 1:
                new Tabuada().imprimir();
                break;
            case 2:
                new IMC().calcular();
                break;
            case 3:
                new TodosParesImpares().executa();
                break;
            case 4:
                new NumerosSequencia().imprime();
                break;
            default:
                System.out.println("Não existe esse exercicio");
        }
    }
}