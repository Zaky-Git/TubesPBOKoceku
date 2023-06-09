package com.koceku.koceku.Model;

public abstract interface Emoney {

    public abstract void payment(String tipeTagihan, String noTagihan, String Status, Double amount);

    public abstract void topUp(Double amount, String recipientPhoneNumber, String note, String ewalletType,
            String status);

    public abstract Ewallet transfer(Double amount, Ewallet recipientEwallet, String note, String ewalletType);

    public abstract void addBalance(Double amount);
}
