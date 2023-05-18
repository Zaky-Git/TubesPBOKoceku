package com.koceku.koceku.Model;

public class history {
    private String type;
    private String phoneNumber;
    private String name;
    private String amount;
    private String status;

    public history(String type, String phoneNumber, String name, String amount, String status) {
        this.type = type;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.amount = amount;
        this.status = status;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
