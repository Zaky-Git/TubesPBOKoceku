package com.koceku.koceku.Model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Ewallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private User user;

    private double balance;

    @OneToMany(mappedBy = "ewallet", cascade = CascadeType.ALL)
    private List<Transaction> transactionHistory = new ArrayList<>();

    // Constructor
    public Ewallet(User user) {
        this.user = user;
        this.balance = 50000;
    }

    // Getter dan Setter
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    // Metode Top Up
    public void topUp(Double amount, String recipientPhoneNumber) {
        // Proses top up dengan metode pembayaran tertentu
        this.balance += amount;
        Transaction transaction = new Transaction(null,
                null,
                amount,
                "Top Up",
                null,
                recipientPhoneNumber,
                null,
                null,
                "Success",
                this);
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
