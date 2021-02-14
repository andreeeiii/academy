package com.academy.learning.repository;

import com.academy.learning.model.Trainer;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.stereotype.Service;

import static com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.builder;

/**
 * Service in charge of Trainer database interaction
 */
@Service
public class TrainerRepository  {

    private static DynamoDBAdapter dbAdapter;
    private final AmazonDynamoDB client;
    private final DynamoDBMapper mapper;

    public TrainerRepository() {

        dbAdapter = DynamoDBAdapter.getInstance();
        client = dbAdapter.getDbClient();
        mapper = dbAdapter.createDbMapper(builder().build());
    }

    public Trainer save(Trainer trainer) {

        this.mapper.save(trainer);

        return trainer;
    }
}
