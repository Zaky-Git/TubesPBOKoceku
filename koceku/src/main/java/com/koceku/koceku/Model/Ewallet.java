package com.koceku.koceku.Model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.koceku.koceku.Repository.UserRepository;

import jakarta.persistence.*;

@Entity
public class Ewallet {

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

    public void topUp(Double amount, String recipientPhoneNumber, String note, String ewalletType, String status) {

        if (status.equals("Success")) {
            this.balance -= amount;
            Transaction transaction = new Transaction(this,
                    amount,
                    "Top Up",
                    ewalletType,
                    recipientPhoneNumber,
                    null,
                    null,
                    "Success",
                    note,
                    LocalDateTime.now(), "Expense");
            addTransactionToHistory(transaction);
            System.out.println("Top up successful. Current balance: " + this.balance);
        } else {
            Transaction transaction = new Transaction(this,
                    amount,
                    "Top Up",
                    ewalletType,
                    recipientPhoneNumber,
                    null,
                    null,
                    "Failed",
                    note,
                    LocalDateTime.now(), "Expense");
            addTransactionToHistory(transaction);
            System.out.println("Top up failed. Current balance: " + this.balance);
        }

    }

    public void addTransactionToHistory(Transaction transaction) {
        if (this.transactions == null) {
            this.transactions = new ArrayList<>();
        }
        transaction.setEwallet(this);
        this.transactions.add(transaction);
    }

    public Ewallet transferToRecipient(Double amount, Ewallet recipientEwallet, String note, String ewalletType) {
        if (this.balance >= amount) {

            Transaction senderTransaction = new Transaction(this, amount, "Transfer",
                    ewalletType, recipientEwallet.getUser().getPhoneNumber(),
                    this.getUser().getFirstName() + " " + this.getUser().getLastName(),
                    recipientEwallet.getUser().getFirstName() + " " + recipientEwallet.getUser().getLastName(),
                    "Success", note,
                    LocalDateTime.now(), "Expense");
            addTransactionToHistory(senderTransaction);

            Transaction recipientTransaction = new Transaction(recipientEwallet, amount, "Transfer",
                    ewalletType, this.getUser().getPhoneNumber(),
                    this.getUser().getFirstName() + " " + this.getUser().getLastName(),
                    recipientEwallet.getUser().getFirstName() + " " + recipientEwallet.getUser().getLastName(),
                    "Success", note,
                    LocalDateTime.now(), "Income");
            recipientEwallet.addTransactionToHistory(recipientTransaction);

            this.minusBalance(amount);

            recipientEwallet.plusBalance(amount);

            return recipientEwallet;
        } else {
            System.out.println("Insufficient balance.");
            return null;
        }
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

}
