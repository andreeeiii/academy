package com.academy.learning.controller;

import com.academy.learning.service.account.AccountService;
import com.academy.learning.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Controller in charge of handling business request for {@link Account}
 */
@RestController
@EnableWebMvc
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(path = "/account", consumes = APPLICATION_JSON)
    public Account saveAccount(@RequestBody Account account) {

        return accountService.createAccount(account);
    }

    @GetMapping(path = "/account", produces = APPLICATION_JSON)
    public String getByUsername(@RequestParam String username) {

        return accountService.getByUsername(username);
    }
}
