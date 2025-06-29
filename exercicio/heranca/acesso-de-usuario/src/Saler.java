public class Saler extends User {
    public Saler(String name, String email, String password) {
        super(name, email, password, false);
    }

    public void addSale(Store store) {
        if (isLogged()) {
            store.setSalesNumber(store.getSalesNumber() + 1);
            System.out.println("Venda adicionada com sucesso");
        } else {
            System.out.println("Você precisa estar logado para adicionar venda");
        }
    }
}


