package AnastasiiaTkachuk;

import java.time.LocalDateTime;
import java.util.List;

public class Bank {
    private List<User> list;
    public void openAccount(User user, String pin){
        System.out.println("Verify your pin");
        if(user.getPin().equals(pin)) {
            user.setAccountStatus(true);
            list.add(user);
        }
        else{
            System.out.println("PIN is incorrect, please try again.");
        }
    }
    public void closeAccount(User user, String pin){
        System.out.println("Verify your pin");
        if(user.getPin().equals(pin)) {
            user.setAccountStatus(false);
            list.remove(user);
        }
        else{
            System.out.println("PIN is incorrect, please try again.");
        }
    }
    public void changePin(User user, String pin){
        System.out.println("Verify your pin");
        if(user.getPin().equals(pin)){
            System.out.println("Enter your new pin");
            boolean pinResult = pin.matches("#^[0-9]{4}$#");
            if(pinResult){
                user.setPin(pin);
            }
        }
    }
}
