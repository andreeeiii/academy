package com.academy.learning.service.account;

import com.academy.learning.model.Account;
import com.academy.learning.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Interface in charge of {@link Account} operations
 */
@Service
public class AccountService {

    private final AccountValidator accountValidator;
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountValidator accountValidator, AccountRepository accountRepository) {
        this.accountValidator = accountValidator;
        this.accountRepository = accountRepository;
    }

    /**
     * processes and creates account using parameter
     * @param account to be used to create account
     * @return created account
     */
    public Account createAccount(Account account) {

        accountValidator.validate(account);

        return accountRepository.save(account);
    }

    public String getByUsername(String username) {

        return accountRepository.getByUsername(username);
    }
}
