package com.academy.learning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "points")
    private int points;
    @Column(name = "details")
    private String details;

    public int getId() {
        return id;
    }

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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
