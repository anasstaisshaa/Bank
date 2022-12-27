package AnastasiiaTkachuk;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ATM {
    private List<Transaction> list = new ArrayList<>();

    public void transferBetweenAccount(User accountFrom, User accountTo, double money) {
            if (accountFrom.isAccountEnabled() && accountTo.isAccountEnabled()) {
                if (accountFrom.getBalance() >= money) {
                    while(true){
                        boolean fromLockResult = accountFrom.getLock().tryLock();
                        boolean toLockResult = accountTo.getLock().tryLock();
                        if (fromLockResult && toLockResult) {
                            break;
                        }
                        if(fromLockResult){
                            accountFrom.getLock().unlock();
                        }
                        if(toLockResult){
                            accountTo.getLock().unlock();
                    }
                        try {
                            double initialBalanceCreditAccount = accountFrom.getBalance();
                            double initialBalanceDebitAccount = accountTo.getBalance();
                            accountFrom.setBalance(accountFrom.getBalance() - money);
                            accountTo.setBalance(accountTo.getBalance() + money);
                            ZonedDateTime dateTime = ZonedDateTime.now();
                            list.add(new Transaction(dateTime, accountFrom, money, "-", initialBalanceCreditAccount, accountFrom.getBalance()));
                            list.add(new Transaction(dateTime, accountTo, money, "+", initialBalanceDebitAccount, accountTo.getBalance()));
                            System.out.printf("User %s sent to user %s %s money.%n", accountFrom.getFullName(), accountTo.getFullName(), money);
                        }finally {
                            accountFrom.getLock().unlock();
                            accountTo.getLock().unlock();
                        }
                        }
                } else {
                    System.out.printf("User %s don't have enough money. Transaction cancelled.%n", accountFrom.getFullName());
                }
            } else {
                System.out.printf("User %s account is not open. Please open it before making any transactions.%n", accountFrom.getFullName());
            }
    }

    public List<Transaction> getHistoryOfTransaction() {
        return list;
    }

    public double getBalance(User user) {
        return user.getBalance();
    }

    public void addToBalance(User user, double money) {
        if (user.isAccountEnabled()) {
            while (true){
                boolean userLockResult = user.getLock().tryLock();
                if(userLockResult)
                    break;
            }
            try{
                double initialBalance = user.getBalance();
                user.setBalance(user.getBalance() + money);
                ZonedDateTime dateTime = ZonedDateTime.now();
                list.add(new Transaction(dateTime, user, money, "+", initialBalance, user.getBalance()));
                System.out.printf("User %s topped up their account with %s%n", user.getFullName(), money);
            } finally {
                user.getLock().unlock();
            }

        } else {
            System.out.println("Your account is not open");
        }
    }

    public void withdraw(User user, double money) {
        if (user.isAccountEnabled()) {
            if (user.getBalance() >= money) {
                while(true){
                    boolean userLockResult = user.getLock().tryLock();
                    if(userLockResult){
                        break;
                    }
                }
                try {
                    double initialBalance = user.getBalance();
                    user.setBalance(user.getBalance() - money);
                    ZonedDateTime dateTime = ZonedDateTime.now();
                    list.add(new Transaction(dateTime, user, money, "w-", initialBalance, user.getBalance()));
                    System.out.printf("User %s withdrawn %s%n", user.getFullName(), money);
                } finally {
                    user.getLock().unlock();
                }

            } else {
                System.out.printf("User %s don't have enough money%n", user.getFullName());
            }
        } else {
            System.out.println("Your account is not open");
        }
    }

}
