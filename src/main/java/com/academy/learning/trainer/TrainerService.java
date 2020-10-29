package com.academy.learning.trainer;

import com.academy.learning.model.Trainer;
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
    public TrainerService(TrainerRepository trainerRepository, TrainerValidator trainerValidator) {
        this.trainerRepository = trainerRepository;
        this.trainerValidator = trainerValidator;
    }

    /**
     * Creates a new Trainer with given details
     * @param trainer given details
     * @return new trainer
     */
    Trainer createTrainer(Trainer trainer) {

        trainerValidator.validate(trainer);

        return trainerRepository.save(trainer);
    }
}
