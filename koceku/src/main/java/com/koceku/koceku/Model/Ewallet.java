package com.koceku.koceku.Model;

public class Ewallet {
    private User user;
    private double balance;
    // Constructor
    public Ewallet(User user){
        this.user = user;
        this.balance = 0;
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
    public void setBalance(double balance) {
        this.balance = balance;
    }
    // Metode Top Up
    public void topUp(double amount) {
        // Proses top up dengan metode pembayaran tertentu
        this.balance += amount;
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
    // Metode Check Balance
    public void checkBalance() {
        System.out.println("Current balance: " + this.balance);
    }
}
