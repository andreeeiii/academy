package com.academy.learning.user;

import com.academy.learning.model.Account;
import com.academy.learning.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * Controller in charge of User activities
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/account/user", consumes = "application/json", produces = "application/json")
    @ResponseStatus(value = CREATED)
    public Account createAccount(@RequestBody User user) {

        return userService.createUser(user);
    }
}
