package com.koceku.koceku.Model;

import jakarta.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String senderId;
    private String recipientId;
    private double amount;
    private String type;
    private String ewalletType;
    private String phoneNumber;
    private String senderName;
    private String recipientName;
    private String status;
    private String note;

    public Transaction(String senderId, String recipientId, double amount, String type,
            String ewalletType, String phoneNumber, String senderName, String recipientName, String status, String note) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.amount = amount;
        this.type = type;
        this.ewalletType = ewalletType;
        this.phoneNumber = phoneNumber;
        this.senderName = senderName;
        this.recipientName = recipientName;
        this.status = status;
        this.note = note;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenderId() {
        return this.senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getRecipientId() {
        return this.recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return this.type;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setType(String type) {
        this.type = type;
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

}
