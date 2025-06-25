import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final WashingMachine washingMachine = new WashingMachine();
    private static Pet pet = new Pet();
    private static final int AMOUNT_WATER = 2;
    private static final int AMOUNT_SHAMPOO = 2;

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var option = -1;

        do {
            System.out.println("=== Selecione uma opção ===");
            System.out.println("0 - Sair");
            System.out.println("1 - Abastecer com água");
            System.out.println("2 - Abastecer com shampoo");
            System.out.println("3 - Verificar nível de água");
            System.out.println("4 - Verificar nível de shampoo");
            System.out.println("5 - Verificar se tem pet no banho");
            System.out.println("6 - Colocar pet no banho");
            System.out.println("7 - Tirar pet do banho");
            System.out.println("8 - Limpar máquina");

            option = scanner.nextInt();

            switch (option) {
                case 0 -> System.exit(-1);
                case 1 -> washingMachine.fillWaterTank(AMOUNT_WATER);
                case 2 -> washingMachine.fillShampooTank(AMOUNT_SHAMPOO);
                case 3 -> washingMachine.checkWaterLevel();
                case 4 -> washingMachine.checkShampooLevel();
                case 5 -> washingMachine.existPetMachine();
                case 6 -> washingMachine.putPetOnMachine(pet);
                case 7 -> washingMachine.takeOutPet (pet);
                case 8 -> washingMachine.cleanMachine();
                default -> System.out.println("Digite uma opção válida");
            }
        }while(option != 0);
    }
}