package com.koceku.koceku.Model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    private String method;
    private String ewalletType;
    private String phoneNumber;
    private String senderName;
    private String recipientName;
    private String status;
    private String note;
    private LocalDateTime transactionDate;
    private String type;
    private String paymentType;
    private String nomorTagihan;

    @ManyToOne
    @JoinColumn(name = "ewallet_id")
    private Ewallet ewallet;

    public Transaction() {

    }

    // transfer
    public Transaction(double amount, String method, String status,
            LocalDateTime transactionDate, String type, String paymentType, String nomorTagihan) {
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.transactionDate = transactionDate;
        this.type = type;
        this.paymentType = paymentType;
        this.nomorTagihan = nomorTagihan;
    }

    // topup
    public Transaction(Ewallet ewallet, double amount, String method,
            String ewalletType, String phoneNumber, String status,
            String note, LocalDateTime transactionDate, String type) {
        this.amount = amount;
        this.method = method;
        this.ewalletType = ewalletType;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.note = note;
        this.transactionDate = transactionDate;
        this.type = type;
    }

    public Transaction(Ewallet ewallet, double amount, String method,
            String ewalletType, String phoneNumber, String senderName, String recipientName, String status,
            String note, LocalDateTime transactionDate, String type, String paymentType, String nomorTagihan) {
        this.amount = amount;
        this.method = method;
        this.ewalletType = ewalletType;
        this.phoneNumber = phoneNumber;
        this.senderName = senderName;
        this.recipientName = recipientName;
        this.status = status;
        this.note = note;
        this.transactionDate = transactionDate;
        this.type = type;
        this.paymentType = paymentType;
        this.nomorTagihan = nomorTagihan;
    }

    public String nomorTagihan() {
        return this.nomorTagihan;
    }

    public void setnomorTagihan(String nomorTagihan) {
        this.nomorTagihan = nomorTagihan;
    }

    public Ewallet getEwallet() {
        return ewallet;
    }

    public void setEwallet(Ewallet ewallet) {
        this.ewallet = ewallet;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getEwalletType() {
        return this.ewalletType;
    }

    public void setEwalletType(String ewalletType) {
        this.ewalletType = ewalletType;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSenderName() {
        return this.senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getRecipientName() {
        return this.recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
