package AnastasiiaTkachuk;

import java.time.LocalDateTime;
import java.util.List;

public class ATM {
    private List<Transaction> list;

    public void transferBetweenAccount(User accountFrom, User accountTo, double money){
        if(accountFrom.isAccountStatus() && accountTo.isAccountStatus()){
            if(accountFrom.getBalance() >= money){
                accountFrom.setBalance(accountFrom.getBalance()-money);
                accountTo.setBalance(accountTo.getBalance()-money);
                LocalDateTime dateTime = LocalDateTime.now();
                list.add(new Transaction(dateTime, money));
            }
            else{
                System.out.println("You don't have enough money");
            }
        }
        else {
            System.out.println("Your accounts are not open");
        }
    }
    public List getHistoryOfTransaction(){
        return list;
    }
    public double getBalance(User user){
        return user.getBalance();
    }
    public void serAmount(User user, double money){
        user.setBalance(user.getBalance()+money);
    }

}
