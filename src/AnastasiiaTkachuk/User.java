package AnastasiiaTkachuk;

public class User {
    private String pin;
    private final String fullName;

    private double balance;
    private boolean AccountStatus = false;
    public User(String  pin, String fullName) {
        System.out.println("You have successfully registered to make bank transactions open an account");
        boolean pinResult = pin.matches("#^[0-9]{4}$#");
        if(pinResult) {
            this.pin = pin;
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
