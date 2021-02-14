package com.academy.learning.service.user;

import com.academy.learning.service.account.AccountValidator;
import com.academy.learning.exception.InvalidUserInputException;
import com.academy.learning.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service in charge of validating user input
 */
@Service
public class UserValidator {

    @Autowired
    private AccountValidator accountValidator;

    /**
     * validates user input
     * @param user input
     */
    public void validate(User user) {

        accountValidator.validate(user);

        if (user.getPoints() != 0) {
            throw new InvalidUserInputException("Newly created users cannot have more than 0 points");
        }
    }
}
