import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Account account;
    private static Scanner scanner;
    private static final String accountBalanceMessage = "Saldo atual R$ %.2f\n";

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        var option = -1;

        do{
            System.out.println("===Escolha uma opção===");
            System.out.println("0 - Sair");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Consultar cheque especial");
            System.out.println("4 - Depositar");
            System.out.println("5 - Sacar");
            System.out.println("6 - Pagar boleto");
            System.out.println("7 - Verificar se conta está no cheque especial");
            System.out.println("8 - Consultar taxa");
            option = scanner.nextInt();

            switch (option){
                case 1 -> account = createAccount();
                case 2 -> getAccountBalance();
                case 3 -> getOverdraft();
                case 4 -> deposit();
                case 5 -> debit("withdraw");
                case 6 -> debit("payBill");
                case 7 -> verifyOverdraft();
                case 8 -> getTax();
                default -> System.out.println("Selecione um valor válido");
            }

        }while(option != 0);
    }

    public static Account createAccount() {
        System.out.println("Insira valor do depósito inicial");

        var amount = scanner.nextDouble();
        var account = new Account(amount);
        var accountBalance = account.getAccountBalance();

        System.out.printf(accountBalanceMessage, accountBalance);

        return account;
    }

    public static void getAccountBalance() {
        var accountBalance = account.getAccountBalance();

        System.out.printf("Saldo atual: R$ %.2f\n", accountBalance);
    }

    public static void getOverdraft() {
        var overdraft = account.getOverdraftLimit();

        System.out.printf("O limite do cheque especial é de R$ %.2f\n", overdraft);
    }

    public static void deposit() {
        System.out.println("Digite o valor para depósito");

        var amount = scanner.nextDouble();
        var newAccountBalance = 0.0D;
        var tax = account.getTax();

        if (tax > 0) {
            var value = amount - tax;
            if (value >= 0) {
                newAccountBalance = account.deposit(value);
                account.setTax(0.00D);

                System.out.printf(accountBalanceMessage, newAccountBalance);
                System.out.printf("Você pagou R$ %.2f de taxa\n", tax);
            } else {
                account.setTax(value * (-1));

                System.out.println("Nenhum valor foi depositado");
                System.out.printf("Você ainda tem R$ %.2f de taxa\n", value * (-1));
            }
        } else {
            newAccountBalance = account.deposit(amount);
            System.out.printf(accountBalanceMessage, newAccountBalance);
        }
    }

    public static void debit(String type) {
        if ("withdraw".equals(type)) {
            System.out.println("Digite o valor do saque: ");
        } else {
            System.out.println("Digite o valor do boleto: ");
        }

        var amount = scanner.nextDouble();

        var overdraftLimit = account.getOverdraftLimit();
        var accountBalance = account.getAccountBalance();
        var newAccountBalance = accountBalance - amount;
        var limit = accountBalance + overdraftLimit;

        if (newAccountBalance < limit) {
            account.setAccountBalance(newAccountBalance);
            if (newAccountBalance < 0) {
                setTax(newAccountBalance);
            }
            System.out.printf(accountBalanceMessage, newAccountBalance);
        } else {
            System.out.println("Você não tem saldo disponível");
        }
    }

    public static void verifyOverdraft() {
        var accountBalance = account.getAccountBalance();
        if (accountBalance < 0) {
            accountBalance = accountBalance * (-1);
            System.out.printf("Você já usou R$ %.2f do cheque especial\n", accountBalance);
        } else {
            System.out.println("Você não está usando o cheque especial\n");
        }
    }

    public static void setTax(double newAccountBalance) {
        var currentTax = account.getTax();
        var tax = (newAccountBalance * (-1) * 0.2);
        var newTax = currentTax + tax;

        account.setTax(newTax);
    }

    public static void getTax() {
        var tax = account.getTax();

        System.out.printf("Valor da taxa do cheque especial é de R$ %.2f\n", tax);
    }
}
