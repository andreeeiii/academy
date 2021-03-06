package com.academy.learning.controller;

import com.academy.learning.model.Trainer;
import com.academy.learning.service.trainer.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.http.HttpStatus.CREATED;

/**
 * Controller in charge of Trainer activities
 */
@RestController
@EnableWebMvc
@CrossOrigin(value = "*")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @PostMapping(value = "/account/trainer", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    @ResponseStatus(value = CREATED)
    public Trainer createTrainer(@RequestBody Trainer trainer) {

        return trainerService.createTrainer(trainer);
    }

    @GetMapping(path = "/account/trainer/{name}", produces = APPLICATION_JSON)
    public Trainer getByName(@PathVariable String name) {

        return trainerService.getByName(name);
    }

    @GetMapping(path = "/account/trainer", produces = APPLICATION_JSON)
    public List<Trainer> getAllTrainers() {

        return trainerService.getAll();
    }
}
