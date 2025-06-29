public class Attendant extends User {
    public Attendant(String name, String email, String password) {
        super(name, email, password, false);
    }

    public void receivePayment(Store store, double value) {
        store.setStoreCashValue(store.getStoreCashValue() + value);

        System.out.println("Valor recebido com sucesso");
    }

    public void closeCahRegister(Store store) {
        if (store.isCashRegister()) {
            store.setCashRegister(false);
            System.out.printf("Caixa fechado com %.2f\n", store.getStoreCashValue());
        } else {
            System.out.println("O caixa não está aberto");
        }
    }
}
