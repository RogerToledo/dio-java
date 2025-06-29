import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static final Double FULL_PRICE = 30.00;

    public static void main(String[] args) {
        while(true) {
            System.out.println("=== Selecione um opção ===");
            System.out.println("0 - Sair");
            System.out.println("1 - Comprar ingresso");
            System.out.println("2 - Comprar ingresso meia entrada");

            var option = scanner.nextInt();

            switch (option) {
                case 0 -> System.exit(-1);
                case 1 -> buyTicket();
                case 2 -> buyHalfPrice();
            }
        }
    }

    public static void buyTicket() {
        System.out.println("Qual filme?");
        scanner.nextLine();
        var movie = scanner.nextLine();
        if ("".equals(movie)) {
            System.out.println("Você precisa escolher um filme");
            return;
        }

        System.out.println("Dublado?");
        var isDubbled = scanner.nextBoolean();

        System.out.println("Quantos ingressos?");
        var numberOfTickets = scanner.nextInt();
        if (numberOfTickets <= 0) {
            System.out.println("Quantidade de ingressos tem que ser maior que ZERO");
            return;
        }

        var ticket = new FamilyTicket(movie, FULL_PRICE, isDubbled, numberOfTickets);

        if (ticket.isFamilyTicket()) {
            var off = (ticket.getPrice() * numberOfTickets) - ticket.getFamilyTicketPrice();

            System.out.printf("Você comprou ingressos família por R$ %.2f e teve %.2f de desconto\n", ticket.getFamilyTicketPrice(), off);
        } else {
            System.out.printf("Total à pagar: R$ %.2f\n", ticket.getFamilyTicketPrice());
        }
    }

    public static void buyHalfPrice() {
        System.out.println("Qual filme?");
        scanner.nextLine();
        var movie = scanner.nextLine();
        if ("".equals(movie)) {
            System.out.println("Você precisa escolher um filme");
            return;
        }

        System.out.println("Dublado?");
        var isDubbled = scanner.nextBoolean();

        System.out.println("Quantos ingressos?");
        var numberOfTickets = scanner.nextInt();
        if (numberOfTickets <= 0) {
            System.out.println("Quantidade de ingressos tem que ser maior que ZERO");
            return;
        }

        var ticket = new FamilyTicket(movie, FULL_PRICE, isDubbled, numberOfTickets);

        var totalPrice = (ticket.getPrice() * numberOfTickets) * 0.5;

        System.out.printf("Total à pagar %.2f\n", totalPrice);
    }
}