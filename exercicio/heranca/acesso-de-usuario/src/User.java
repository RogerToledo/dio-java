public abstract class User {
    private String name;
    private String email;
    private String password;
    private boolean logged;
    private boolean administrator;

    public User(String name, String email, String password, boolean administrator) {
        this.name = name;
        this.email = email;
        this.password = password;

        this.administrator = administrator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public void login(String email, String password) {
        if (!isLogged()) {
            if (email.equals(getEmail()) && password.equals(getPassword())) {
                setLogged(true);
                System.out.println("Usuário logado");
            } else {
                System.out.println("Email ou senha estão errados");
            }
        } else {
            System.out.println("Usuário já está logado");
        }
    }

    public void logout() {
        if (isLogged()) {
            setLogged(false);
            System.out.println("Deslogado com sucesso");
        } else {
            System.out.println("O usuário não está logado");
        }
    }

    public void alterData(String name, String email) {
        setName(name);
        setEmail(email);
    }

    public void alterPassword(String password) {
        setPassword(password);
    }

    public void createFinancialReport() {
        if (isAdministrator()) {
            if (isLogged()) {
                System.out.println("Relatório criado com sucesso");
            } else {
                System.out.println("Você precisa logar antes de criar relatório");
            }
        } else {
            System.out.println("Você não tem acesso para gerar relatórios");
        }
    }

    public void viewSalesReport(Store store) {
        if (isLogged()) {
            System.out.printf("Vendas até o momento: %d\n", store.getSalesNumber());
            System.out.printf("Dinheiro em caixa: %.2f\n", store.getStoreCashValue());
        } else {
            System.out.println("Você precisa logar para consultar vendas");
        }
    }
}


