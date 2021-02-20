package com.academy.learning.service.trainer;

import com.academy.learning.model.Trainer;
import com.academy.learning.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service in charge of Trainer business related operations
 */
@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;
    private final TrainerValidator trainerValidator;

    @Autowired
    public TrainerService(TrainerValidator trainerValidator, TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
        this.trainerValidator = trainerValidator;
    }

    /**
     * Creates a new Trainer with givCen details
     * @param trainer given details
     * @return new trainer
     */
    public Trainer createTrainer(Trainer trainer) {

        trainerValidator.validate(trainer);

        return trainerRepository.save(trainer);
    }

    public Trainer getByName(String name) {

        return trainerRepository.getByName(name);
    }
}
