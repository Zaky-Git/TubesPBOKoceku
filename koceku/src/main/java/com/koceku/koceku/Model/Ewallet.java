package com.koceku.koceku.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Ewallet implements Emoney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double balance;

    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user", referencedColumnName = "userId")
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "ewallet")
    private List<Transaction> transactions;

    public Ewallet() {
        this.balance = 50000;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void plusBalance(Double balance) {
        this.balance += balance;
    }

    public void minusBalance(Double balance) {
        this.balance -= balance;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public void resetTransactions() {
        this.transactions = new ArrayList<>();
    }

    @Override
    public void payment(String tipeTagihan, String noTagihan, String status, Double amount) {
        if (status.equals("Success")) {
            this.minusBalance(amount);
            Transaction transaction = new Transaction(amount, "Payment", status,
                    LocalDateTime.now(), "Expense", tipeTagihan, noTagihan);
            addTransactionToHistory(transaction);
            System.out.println("Payment successful. Current balance: " + this.balance);
        } else {
            Transaction transaction = new Transaction(amount, "Payment", status,
                    LocalDateTime.now(), "Expense", tipeTagihan, noTagihan);
            addTransactionToHistory(transaction);
            System.out.println("Payment failed. Current balance: " + this.balance);
        }
    }

    @Override
    public void topUp(Double amount, String recipientPhoneNumber, String note, String ewalletType, String status) {
        if (status.equals("Success")) {
            this.minusBalance(amount);
        }
        Transaction transaction = new Transaction(this,
                amount,
                "Top Up",
                ewalletType,
                recipientPhoneNumber,
                status,
                note,
                LocalDateTime.now(),
                "Expense");
        addTransactionToHistory(transaction);

        if (status.equals("Success")) {
            System.out.println("Top up successful. Current balance: " + this.balance);
        } else {
            System.out.println("Top up failed. Current balance: " + this.balance);
        }
    }

    @Override
    public Ewallet transfer(Double amount, Ewallet recipientEwallet, String note, String ewalletType) {
        if (this.balance >= amount) {
            Transaction senderTransaction = new Transaction(this, amount, "Transfer", ewalletType,
                    recipientEwallet.getUser().getPhoneNumber(),
                    this.getUser().getFirstName() + " " + this.getUser().getLastName(),
                    recipientEwallet.getUser().getFirstName() + " " + recipientEwallet.getUser().getLastName(),
                    "Success", note, LocalDateTime.now(), "Expense", null, null);
            addTransactionToHistory(senderTransaction);
            Transaction recipientTransaction = new Transaction(recipientEwallet, amount, "Transfer", ewalletType,
                    this.getUser().getPhoneNumber(), this.getUser().getFirstName() + " " + this.getUser().getLastName(),
                    recipientEwallet.getUser().getFirstName() + " " + recipientEwallet.getUser().getLastName(),
                    "Success", note, LocalDateTime.now(), "Income", null, null);
            recipientEwallet.addTransactionToHistory(recipientTransaction);
            this.minusBalance(amount);
            recipientEwallet.plusBalance(amount);
            return recipientEwallet;
        } else {
            System.out.println("Insufficient balance.");
            return null;
        }
    }

    public void addBalance(Double amount) {
        plusBalance(amount);
    }

    public void addTransactionToHistory(Transaction transaction) {
        if (this.transactions == null) {
            this.transactions = new ArrayList<>();
        }
        transaction.setEwallet(this);
        this.transactions.add(transaction);
    }
}
