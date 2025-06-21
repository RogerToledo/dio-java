public class Account {
    private double accountBalance;
    private final double overdraftLimit;
    private double tax;

    public Account(double amount) {
        this.accountBalance = amount;
        this.overdraftLimit = setOverdraft(amount);
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public double getTax() {
        return tax;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double deposit(double amount) {
        var accoutBalance = getAccountBalance();
        var newAccountBalance = accoutBalance + amount;

        setAccountBalance(newAccountBalance);

        return newAccountBalance;
    }

    private double setOverdraft(double amount) {
        double overdraft;

        if (amount <= 500) {
            overdraft = amount * 0.1;
        } else {
            overdraft = amount * 0.5;
        }

        return overdraft;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
