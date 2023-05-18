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
    private Long userId;

    @Column(nullable = false)
    private String nama;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "ewallet_id")
    private Ewallet ewallet;

    // Constructors, getters, and setters

    // Constructor
    public User(Long userId, String nama, String email, String phoneNumber, Ewallet ewallet) {
        this.userId = userId;
        this.nama = nama;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.ewallet = ewallet;
    }

    // Getter dan Setter
    public Long getUserId() {
        return userId;
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

    public void setEwallet(Ewallet ewallet) {
        this.ewallet = ewallet;
    }
}
