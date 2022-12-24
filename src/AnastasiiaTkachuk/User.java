package AnastasiiaTkachuk;

public class User {
    private String pin;
    private final String fullName;
    private String login;

    private double balance;
    private boolean AccountStatus = false;

    public User(String pin, String fullName, String login) {
        boolean pinResult = pin.matches("#^[0-9]{4}$#");
        boolean loginResult = login.matches("#^[0-9a-zA-Z]{24}$#");
        if (pinResult && loginResult) {
            this.pin = pin;
            this.login = login;
            System.out.println("You have successfully registered to make bank transactions open an account");
        }
        this.fullName = fullName;
    }

    public boolean isAccountStatus() {
        return AccountStatus;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountStatus(boolean accountStatus) {
        AccountStatus = accountStatus;
    }

    public String getPin() {
        return pin;
    }

    public String getFullName() {
        return fullName;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "User{" +
                "pin='" + pin + '\'' +
                ", fullName='" + fullName + '\'' +
                ", balance=" + balance +
                ", AccountStatus=" + AccountStatus +
                '}';
    }
}
