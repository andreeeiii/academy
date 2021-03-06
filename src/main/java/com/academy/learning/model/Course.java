package com.academy.learning.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.Date;

@DynamoDBTable(tableName = "Course")
public class Course {

    private String name;
    private int points;
    private String details;
    private Difficulty difficulty;
    private Double price;
    private Integer duration;
    private Type type;
    private Date startDate;

    public Course() {
    }

    @DynamoDBHashKey(attributeName = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @DynamoDBAttribute
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @DynamoDBTypeConvertedEnum
    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @DynamoDBAttribute
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @DynamoDBAttribute
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @DynamoDBTypeConvertedEnum
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @DynamoDBTypeConvertedTimestamp(pattern="yyyyMMddHHmm", timeZone="UTC")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
