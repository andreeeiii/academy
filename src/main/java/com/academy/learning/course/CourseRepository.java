package com.academy.learning.course;

import com.academy.learning.db.DynamoDBAdapter;
import com.academy.learning.model.Course;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.*;

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
}
