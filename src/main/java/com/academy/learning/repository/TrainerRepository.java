package com.academy.learning.repository;

import com.academy.learning.exception.InvalidTrainerInputException;
import com.academy.learning.model.Trainer;
import com.academy.learning.model.User;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

    public Trainer getByName(String name) {

        DynamoDBScanExpression scanExp = new DynamoDBScanExpression();

        List<Trainer> trainers = this.mapper.scan(Trainer.class, scanExp);

        Optional<Trainer> matchingTrainer = trainers.stream()
                .filter(trainer -> trainer.getName().equals(name))
                .findFirst();

        return matchingTrainer.orElseThrow(() -> new InvalidTrainerInputException("Trainer does not exist"));
    }
}
