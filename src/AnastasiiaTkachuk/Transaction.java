package AnastasiiaTkachuk;

import java.time.LocalDateTime;

import java.time.ZonedDateTime;
import java.util.List;

public class Transaction {
    private final ZonedDateTime date;

    private final User user;

    private final String transactionType;
    private final double amount;
    private final double initialBalance;
    private final double resultBalance;

    public Transaction(ZonedDateTime date, User user, double amount, String transactionType, double initialBalance, double resultBalance) {
        this.date = date;
        this.user = user;
        this.transactionType = transactionType;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.resultBalance = resultBalance;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", user=" + user.getFullName() +
                ", initialBalance=" + initialBalance +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                ", resultBalance=" + resultBalance +
                '}' + System.lineSeparator();
    }
}

