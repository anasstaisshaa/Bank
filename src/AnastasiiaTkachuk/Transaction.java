package AnastasiiaTkachuk;

import java.time.LocalDateTime;

import java.util.List;

public class Transaction {
    private LocalDateTime date;
    private double amount;

    public Transaction(LocalDateTime date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", amount=" + amount +
                '}';
    }
}

