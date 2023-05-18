package com.koceku.koceku.Model;

public class User {
    private String userId;
    private String noHp;
    private String nama;
    private String email;
    private String phoneNumber;
    // tambahkan atribut lain yang diperlukan

    // Constructor
    public User(String userId, String email, String phoneNumber) {
        this.userId = userId;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getter dan Setter
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
