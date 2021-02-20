package com.academy.learning.repository;

import com.academy.learning.model.Course;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.*;
import static java.util.Objects.isNull;

@Service
public class CourseRepository {

    private static DynamoDBAdapter dbAdapter;
    private final AmazonDynamoDB client;
    private final DynamoDBMapper mapper;

    public CourseRepository() {

        dbAdapter = DynamoDBAdapter.getInstance();
        client = dbAdapter.getDbClient();
        mapper = dbAdapter.createDbMapper(builder().build());
    }

    /**
     *
     * @param course
     */
    public Course save(Course course) {

        this.mapper.save(course);

        return course;
    }

    /**
     *
     * @return
     */
    public List<Course> getAll() {

        DynamoDBScanExpression scanExp = new DynamoDBScanExpression();
        return this.mapper.scan(Course.class, scanExp);
    }

    public String getByName(String name) {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Course");

        Item item = table.getItem("name", name);

        return isNull(item) ? "The course searched does not exist" : item.toJSONPretty();
    }
}
