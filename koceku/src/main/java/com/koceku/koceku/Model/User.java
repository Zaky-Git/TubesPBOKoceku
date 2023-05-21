package com.koceku.koceku.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false)
    private String nama;

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @OneToOne(mappedBy = "user")
    @JoinColumn(name = "ewallet_id")
    private Ewallet ewallet;

    public User() {
    }

    // Constructors, getters, and setters

    // Constructor
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

    public String getPassword(){
        return password;
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

    public String getNama() {
        return nama;
    }

    public Ewallet getEwallet() {
        return ewallet;
    }

}
