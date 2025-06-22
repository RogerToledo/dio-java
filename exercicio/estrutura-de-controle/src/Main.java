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

        var exercicio = 4;

        switch (exercicio) {
            case 1:
                var tabuada = new Tabuada();
                tabuada.Tabuada();
                break;
            case 2:
                var imc = new IMC();
                imc.imc();
                break;
            case 3:
                var parImpar = new TodosParesImpares();
                parImpar.todosParesImpares();
                break;
            case 4:
                var numSeq = new NumerosSequencia();
                numSeq.NumeroSequencia();
                break;
            default:
                System.out.println("Não existe esse exercicio");
        }
    }
}