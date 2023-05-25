package koceku.koceku.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Ewallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double balance;

    @OneToMany(targetEntity = Transaction.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_transaction", referencedColumnName = "Id")
    private List<Transaction> transactionHistory;

    // Constructor
    public Ewallet() {
        this.balance = 50000;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    // Metode Top Up
    public void topUp(Double amount, String recipientPhoneNumber) {
        // Proses top up dengan metode pembayaran tertentu
        this.balance -= amount;
        Transaction transaction = new Transaction(null,
                null,
                amount,
                "Top Up",
                null,
                recipientPhoneNumber,
                null,
                null,
                "Success");
        addTransactionToHistory(transaction);
        System.out.println("Top up successful. Current balance: " + this.balance);
    }

    // Metode Transfer
    public void transfer(String recipientId, double amount) {
        if (this.balance >= amount) {
            // Proses transfer ke penerima dengan ID tertentu
            this.balance -= amount;
            System.out.println("Transfer successful. Current balance: " + this.balance);
        } else {
            System.out.println("Insufficient balance to perform the transfer.");
        }
    }

    public void addTransactionToHistory(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

}
