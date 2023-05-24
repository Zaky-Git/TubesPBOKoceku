package com.koceku.koceku.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_Name")
    private String nama;

    @Column(name = "user_Email")
    private String email;

    @Column(name = "user_phoneNumber")
    private String phoneNumber;

    @Column(name = "user_Password")
    private String password;

    @OneToOne(mappedBy = "user")
    @JoinColumn(name = "user_EWallet_Id")
    private Ewallet ewallet;

    // Constructors, getters, and setters

    // Constructor
    public User(){
        
    }
    public User(String nama, String email, String phoneNumber, String password, Ewallet ewallet) {
        this.nama = nama;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.ewallet = ewallet;
    }

    // Getter dan Setter
    public int getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEwallet(Ewallet ewallet) {
        this.ewallet = ewallet;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getNama() {
        return nama;
    }

    public Ewallet getEwallet() {
        return ewallet;
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", nama='" + getNama() + "'" +
            ", email='" + getEmail() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", password='" + getPassword() + "'" +
            ", ewallet='" + getEwallet() + "'" +
            "}";
    }

}
