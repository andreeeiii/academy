package com.academy.learning.account;

import com.academy.learning.db.DynamoDBAdapter;
import com.academy.learning.model.Account;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.stereotype.Service;

import static com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.builder;

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
}
