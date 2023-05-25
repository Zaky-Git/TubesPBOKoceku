package com.koceku.koceku.Model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @OneToOne(targetEntity = Ewallet.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_ewallet", referencedColumnName = "id")
    private Ewallet ewallet;

    public User() {
    }

    // Constructor
    public User(String firstName, String lastName, String email, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    // Getter dan Setter

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Ewallet getEwallet() {
        return this.ewallet;
    }

    public void setEwallet(Ewallet ewallet) {
        this.ewallet = ewallet;
    }

    @Override
    public String toString() {
        return "{" +
                " userId='" + getUserId() + "'" +
                ", firstName='" + getFirstName() + "'" +
                ", lastName='" + getLastName() + "'" +
                ", email='" + getEmail() + "'" +
                ", phoneNumber='" + getPhoneNumber() + "'" +
                ", password='" + getPassword() + "'" +
                ", ewallet='" + "'" +
                "}";
    }

}
