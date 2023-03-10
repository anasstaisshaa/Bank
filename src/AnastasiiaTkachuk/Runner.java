package AnastasiiaTkachuk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Runner {
    private static Double withdrawnAmount = 0d;
    static Bank bank = new Bank();
    static ATM atm1 = new ATM();
    static User user1;
    static User user2;

    public static void main(String[] args) throws InterruptedException {
        user1 = new User("1111", "John Doe", "john1111");
        user2 = new User("1112", "Mark Twain", "mark1112");

        bank.openAccount(user1, "1111");
        bank.openAccount(user2, "1112");

        atm1.addToBalance(user1, 100_000d);
        atm1.addToBalance(user2, 100_000d);


        System.out.printf("ATM1 history %s%n", atm1.getHistoryOfTransaction());
        System.out.printf("User1 has balance %s%n", user1.getBalance());
        System.out.printf("User2 has balance %s%n", user2.getBalance());

        ExecutorService threadExecutor = Executors.newFixedThreadPool(3);
        threadExecutor.submit(() -> {
            for (int i = 0; i < 10; i++) {
                atm1.transferBetweenAccount(user2, user1, 100d);
            }
        });

        threadExecutor.submit(() -> {
            for (int i = 0; i < 10; i++) {
                atm1.transferBetweenAccount(user1, user2, 100d);
            }
        });

        threadExecutor.submit(() -> {
            for (int i = 0; i < 10; i++) {
                atm1.withdraw(user1, 50d);
                synchronized (withdrawnAmount) {
                    withdrawnAmount -= 50d;
                }
            }
        });
        threadExecutor.awaitTermination(3L, TimeUnit.SECONDS);
        threadExecutor.shutdown();


        System.out.printf("ATM1 history%n%s%n", atm1.getHistoryOfTransaction());
        System.out.printf("User1 has balance %s%n", user1.getBalance());
        System.out.printf("User2 has balance %s%n", user2.getBalance());
        System.out.printf("Withdrawn total %s%n", withdrawnAmount);
        System.out.printf("Total balance (u1 + u2 + w) is %s%n", user1.getBalance() + user2.getBalance() + withdrawnAmount);

    }

}
