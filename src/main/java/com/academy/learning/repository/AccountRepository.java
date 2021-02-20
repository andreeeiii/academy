package com.academy.learning.repository;

import com.academy.learning.model.Account;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import org.springframework.stereotype.Service;

import static com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.builder;
import static java.util.Objects.isNull;

@Service
public class AccountRepository {

    private static DynamoDBAdapter dbAdapter;
    private final AmazonDynamoDB client;
    private final DynamoDBMapper mapper;

    public AccountRepository() {

        dbAdapter = DynamoDBAdapter.getInstance();
        client = dbAdapter.getDbClient();
        mapper = dbAdapter.createDbMapper(builder().build());
    }

    public Account save(Account account) {

        this.mapper.save(account);

        return account;
    }

    public String getByUsername(String username) {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Account");

        Item item = table.getItem("username", username);

        return isNull(item) ? "The account searched does not match the criteria" : item.toJSONPretty();
    }
}
