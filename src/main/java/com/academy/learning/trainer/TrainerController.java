package com.academy.learning.trainer;

import com.academy.learning.model.Account;
import com.academy.learning.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * Controller in charge of Trainer activities
 */
@RestController
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @PostMapping(value = "/account/trainer", consumes = "application/json", produces = "application/json")
    @ResponseStatus(value = CREATED)
    public Account createAccount(@RequestBody Trainer trainer) {

        return trainerService.createTrainer(trainer);
    }
}
