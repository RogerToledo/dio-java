import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static WashingMachine washingMachine;
    private static Pet pet;
    private static final int AMOUNT_WATER = 2;
    private static final int AMOUNT_SHAMPOO = 2;

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var option = -1;

        do {
            System.out.println("=== Selecione uma opção ===");
            System.out.println("0 - Sair");
            System.out.println("1 - Criar máquina de banho");
            System.out.println("2 - Criar pet");
            System.out.println("3 - Abastecer com água");
            System.out.println("4 - Abastecer com shampoo");
            System.out.println("5 - Verificar nível de água");
            System.out.println("6 - Verificar nível de shampoo");
            System.out.println("7 - Verificar se tem pet no banho");
            System.out.println("8 - Colocar pet no banho");
            System.out.println("9 - Tirar pet do banho");
            System.out.println("10 - Limpar máquina");

            option = scanner.nextInt();

            switch (option) {
                case 0 -> System.exit(-1);
                case 1 -> washingMachine = new WashingMachine();
                case 2 -> pet = new Pet("kyara");
                case 3 -> washingMachine.fillWaterTank(AMOUNT_WATER);
                case 4 -> washingMachine.fillShampooTank(AMOUNT_SHAMPOO);
                case 5 -> washingMachine.checkWaterLevel();
                case 6 -> washingMachine.checkShampooLevel();
                case 7 -> washingMachine.existPetMachine();
                case 8 -> washingMachine.putPetOnMachine(pet);
                case 9 -> washingMachine.takeOutPet();
                case 10 -> washingMachine.cleanMachine();
                default -> System.out.println("Digite uma opção válida");
            }
        }while(option != 0);
    }
}