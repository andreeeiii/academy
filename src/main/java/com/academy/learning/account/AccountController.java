package com.academy.learning.account;

import com.academy.learning.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * Controller in charge of handling business request for {@link Account}
 */
@RestController
@EnableWebMvc
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/account", consumes = "application/json", produces = "application/json")
    @ResponseStatus(value = CREATED)
    public Account saveAccount(@RequestBody Account account) {

        return accountService.createAccount(account);
    }
}
