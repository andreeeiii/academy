package com.academy.learning.account;

import com.academy.learning.exception.InvalidAccountInputException;
import com.academy.learning.model.Account;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

/**
 * Validator in charge of validating Account fields
 */
@Service
public class AccountValidator {

    /**
     * validates account fields
     * @param account given account
     */
    public void validate(Account account) {

        if (isNull(account.getUsername())) {
            throw new InvalidAccountInputException("Username cannot be empty");
        }

        if (isNull(account.getPassword())) {
            throw new InvalidAccountInputException("Password cannot be empty");
        }

        if (isNull(account.getEmail())) {
            throw new InvalidAccountInputException("Email cannot be empty");
        }
    }
}
