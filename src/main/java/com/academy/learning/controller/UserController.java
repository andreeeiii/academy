package com.academy.learning.controller;

import com.academy.learning.model.Account;
import com.academy.learning.model.User;
import com.academy.learning.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Controller in charge of User activities
 */
@RestController
@EnableWebMvc
@CrossOrigin(value = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/account/user", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    @ResponseStatus(value = CREATED)
    public Account createUser(@RequestBody User user) {

        return userService.createUser(user);
    }

    @RequestMapping(path = "/account/user", method = GET, produces = APPLICATION_JSON)
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }
}
