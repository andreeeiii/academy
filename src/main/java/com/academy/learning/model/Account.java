package com.academy.learning.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

/**
 * Model class representing account of user
 */
@DynamoDBTable(tableName = "Account")
public class Account {

    private String username;
    private String password;
    private String email;

    public Account() {}

    public Account(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @DynamoDBHashKey(attributeName = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @DynamoDBAttribute
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @DynamoDBAttribute
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
