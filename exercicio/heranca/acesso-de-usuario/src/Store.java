public class Store {
    private int salesNumber;
    private double storeCashValue;
    private boolean cashRegister;

    public Store() {
        this.cashRegister = true;
    }

    public double getStoreCashValue() {
        return storeCashValue;
    }

    public void setStoreCashValue(double storeCashValue) {
        this.storeCashValue = storeCashValue;
    }

    public boolean isCashRegister() {
        return cashRegister;
    }

    public void setCashRegister(boolean cashRegister) {
        this.cashRegister = cashRegister;
    }


    public int getSalesNumber() {
        return salesNumber;
    }

    public void setSalesNumber(int salesNumber) {
        this.salesNumber = salesNumber;
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
