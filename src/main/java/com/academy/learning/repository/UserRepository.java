package com.academy.learning.repository;


import com.academy.learning.model.User;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.builder;

/**
 * Repository in charge of User database interaction
 */
@Service
public class UserRepository {

    private static DynamoDBAdapter dbAdapter;
    private final AmazonDynamoDB client;
    private final DynamoDBMapper mapper;

    public UserRepository() {

        dbAdapter = DynamoDBAdapter.getInstance();
        client = dbAdapter.getDbClient();
        mapper = dbAdapter.createDbMapper(builder().build());
    }

    /**
     *
     * @param user
     * @return
     */
    public User save(User user) {

        this.mapper.save(user);

        return user;
    }

    /**
     *
     * @param id
     * @return
     */
    public String getOne(Integer id) {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("User");

        Item item = table.getItem("Id", id);

        return item.toJSONPretty();
    }

    public List<User> findAll() {

        DynamoDBScanExpression scanExp = new DynamoDBScanExpression();
        return this.mapper.scan(User.class, scanExp);
    }
}
