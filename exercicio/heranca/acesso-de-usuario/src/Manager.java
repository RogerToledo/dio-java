public class Manager extends User {
    private boolean logged;

    public Manager(String name, String email, String password) {
        super(name, email, password, true);
        this.logged = false;
    }
}
