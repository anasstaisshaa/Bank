package AnastasiiaTkachuk;

import java.time.LocalDateTime;

public class Bank {
    public void OpenAccount(User user, String pin){
        System.out.println("Verify your pin");
        if(user.getPin().equals(pin))
            user.setAccountStatus(true);
        else{
            System.out.println("PIN is incorrect, please try again.");
        }
    }
    public void CloseAccount(User user, String pin){
        System.out.println("Verify your pin");
        if(user.getPin().equals(pin))
            user.setAccountStatus(false);
        else{
            System.out.println("PIN is incorrect, please try again.");
        }
    }
    public void ChangePin(User user, String pin){
        System.out.println("Verify your pin");
        if(user.getPin().equals(pin)){
            System.out.println("Enter your new pin");
            boolean pinResult = pin.matches("#^[0-9]{4}$#");
            if(pinResult){
                user.setPin(pin);
            }
        }
    }
    public void TransferBetweenAccount(User accountFrom, User accountTo, double money){
        if(accountFrom.isAccountStatus() && accountTo.isAccountStatus()){
            if(accountFrom.getBalance() >= money){
                accountFrom.setBalance(accountFrom.getBalance()-money);
                accountTo.setBalance(accountTo.getBalance()-money);
                LocalDateTime dateTime = LocalDateTime.now();
                new Transaction(dateTime, money).setList(new Transaction(dateTime, money));
            }
            else{
                System.out.println("You don't have enough money");
            }
        }
        else {
            System.out.println("Your accounts are not open");
        }
    }
}
