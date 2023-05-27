package com.koceku.koceku.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Ewallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double balance;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "ewallet")
    private List<Transaction> transactions;

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

    // Metode Top Up
    public void topUp(Double amount, String recipientPhoneNumber, String note, String ewalletType, String status) {
        // Proses top up dengan metode pembayaran tertentu
        if (status.equals("Success")) {
            this.balance -= amount;
            Transaction transaction = new Transaction(this, null,
                    null,
                    amount,
                    "Top Up",
                    ewalletType,
                    recipientPhoneNumber,
                    null,
                    null,
                    "Success",
                    note);
            addTransactionToHistory(transaction);
            System.out.println("Top up successful. Current balance: " + this.balance);
        } else {
            Transaction transaction = new Transaction(this, null,
                    null,
                    amount,
                    "Top Up",
                    ewalletType,
                    recipientPhoneNumber,
                    null,
                    null,
                    "Failed",
                    note);
            addTransactionToHistory(transaction);
            System.out.println("Top up failed. Current balance: " + this.balance);
        }

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
        if (this.transactions == null) {
            this.transactions = new ArrayList<>();
        }
        transaction.setEwallet(this); // Set Ewallet as the owner of the relationship
        this.transactions.add(transaction);
    }

}
