package com.academy.learning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import static javax.persistence.EnumType.*;

@Entity
@Table(name = "User")
public class User extends Account {

    @Column(name = "name")
    private String name;
    @Column(name = "points")
    private int points;
    @Column(name = "membership")
    @Enumerated(value = STRING)
    private Membership membership;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }
}
