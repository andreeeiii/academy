package com.academy.learning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.InheritanceType.JOINED;
import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

/**
 * Model class representing account of user
 */
@Entity
@Table(name = "Account")
@Inheritance(strategy = JOINED)
public class Account {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = AUTO)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;

    public Account() {

    }

    public Account(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
