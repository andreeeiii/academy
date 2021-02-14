package com.academy.learning.service.trainer;

import com.academy.learning.service.account.AccountValidator;
import com.academy.learning.exception.InvalidTrainerInputException;
import com.academy.learning.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerValidator {

    @Autowired
    private AccountValidator accountValidator;

    /**
     * validates trainer input
     * @param trainer given input
     */
    void validate(Trainer trainer) {

        accountValidator.validate(trainer);

        if (trainer.getRating() > 5.0) {
            throw new InvalidTrainerInputException("Rating cannot be over 5.0");
        }
    }
}
