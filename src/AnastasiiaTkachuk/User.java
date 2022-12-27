package AnastasiiaTkachuk;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class User {
    private String pin;
    private final String fullName;
    private String login;

    private double balance;
    private boolean AccountStatus = false;
    private final Lock lock = new ReentrantLock();

    public User(String pin, String fullName, String login) {
        boolean pinResult = pin.matches("^[0-9]{4}$");
        boolean loginResult = login.matches("^[0-9a-zA-Z]{4,24}$");
        if (pinResult && loginResult) {
            this.pin = pin;
            this.login = login;
            this.fullName = fullName;
            System.out.printf("You have successfully registered user %s to make bank transactions. Now please open an account%n", fullName);
        } else {
            throw new RuntimeException("PIN or LOGIN are not acceptable. Please use correct format for PIN or LOGIN");
        }
    }

    public boolean isAccountEnabled() {
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

    public Lock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "User{" +
//                "pin='" + pin + '\'' +
                ", fullName='" + fullName + '\'' +
                ", balance=" + balance +
                ", AccountStatus=" + AccountStatus +
                '}';
    }
}
