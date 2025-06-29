import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Store store = new Store();

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Escolha um opção ===");
            System.out.println("0 - Sair");
            System.out.println("1 - Gerente");
            System.out.println("2 - Vendedor");
            System.out.println("3 - Atendente");

            var option = scanner.nextInt();

            switch (option) {
                case 0 -> System.exit(-1);
                case 1 -> getManager();
                case 2 -> getSalesMan();
                case 3 -> getAttendant();
            }
        }
    }

    public static void getManager() {
        var looping = true;

        var manager = new Manager("Igor", "igor@mail.com", "igor123");

        while (looping) {
            System.out.println("=== Escolha uma opção ===");
            System.out.println("0 - Sair");
            System.out.println("1 - Logar");
            System.out.println("2 - Deslogar");
            System.out.println("3 - Criar relatório");
            System.out.println("4 - Consultar vendas");

            var option = scanner.nextInt();

            switch (option) {
                case 0 -> looping = false;
                case 1 -> login(manager);
                case 2 -> manager.logout();
                case 3 -> manager.createFinancialReport();
                case 4 -> manager.viewSalesReport(store);
            }
        }
    }

    public static void getSalesMan() {
        var looping = true;

        var saler = new Saler("Vera", "vera@mail.com", "vera123");

        while (looping) {
            System.out.println("=== Escolha uma opção ===");
            System.out.println("0 - Sair");
            System.out.println("1 - Logar");
            System.out.println("2 - Deslogar");
            System.out.println("3 - Realizar venda");
            System.out.println("4 - Consultar vendas");

            var option = scanner.nextInt();

            switch (option) {
                case 0 -> looping = false;
                case 1 -> login(saler);
                case 2 -> saler.logout();
                case 3 -> saler.addSale(store);
                case 4 -> saler.viewSalesReport(store);
            }
        }
    }

    public static void getAttendant() {
        var looping = true;

        var attendant = new Attendant("Isa", "isa@mail.com", "isa123");

        while (looping) {
            System.out.println("=== Escolha uma opção ===");
            System.out.println("0 - Sair");
            System.out.println("1 - Logar");
            System.out.println("2 - Deslogar");
            System.out.println("3 - Receber pagamentos");
            System.out.println("4 - Fechar caixa");

            var option = scanner.nextInt();

            switch (option) {
                case 0 -> looping = false;
                case 1 -> login(attendant);
                case 2 -> attendant.logout();
                case 3 -> receivePayment(attendant);
                case 4 -> attendant.closeCahRegister(store);
            }
        }
    }

    public static void login(User user) {
        System.out.println("Digite o e-mail: ");
        var email = scanner.next();

        System.out.println("Digite a senha: ");
        var password = scanner.next();

        user.login(email, password);
    }

    public static void receivePayment(Attendant attendant) {
        if (attendant.isLogged()) {
            System.out.println("Digite o valor do pagamento: ");
            var amount = scanner.nextDouble();

            attendant.receivePayment(store, amount);
        } else {
            System.out.println("Você não está logado");
        }
    }
}