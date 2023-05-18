package com.koceku.koceku.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private String senderId;
    private String recipientId;
    private double amount;
    private String type;
    private String ewalletType;
    private String phoneNumber;
    private String senderName;
    private String recipientName;
    private String status;

    @ManyToOne
    private Ewallet ewallet;

    public Transaction(String senderId, String recipientId, double amount, String type,
            String ewalletType, String phoneNumber, String senderName, String recipientName, String status,
            Ewallet ewallet) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.amount = amount;
        this.type = type;
        this.ewalletType = ewalletType;
        this.phoneNumber = phoneNumber;
        this.senderName = senderName;
        this.recipientName = recipientName;
        this.status = status;
        this.ewallet = ewallet;
    }

    public Long getTransactionId() {
        return this.transactionId;
    }

    public String getSenderId() {
        return this.senderId;
    }

    public String getRecipientId() {
        return this.recipientId;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getType() {
        return this.type;
    }

    public String getEwalletType() {
        return this.ewalletType;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getSenderName() {
        return this.senderName;
    }

    public String getRecipientName() {
        return this.recipientName;
    }

    public String getStatus() {
        return this.status;
    }

    public Ewallet getEwallet() {
        return this.ewallet;
    }

}
