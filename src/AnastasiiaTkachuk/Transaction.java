package AnastasiiaTkachuk;

import java.time.LocalDateTime;

import java.util.List;

public class Transaction {
    private LocalDateTime date;
    private double amount;
    private List<Transaction> list;

    public Transaction(LocalDateTime date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public List<Transaction> getList() {
        return list;
    }

    public void setList(Transaction transaction) {
        this.list.add(transaction);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", amount=" + amount +
                ", list=" + list +
                '}';
    }
}

