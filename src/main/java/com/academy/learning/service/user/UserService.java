package com.academy.learning.service.user;

import com.academy.learning.model.User;
import com.academy.learning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service in charge of bussiness-side related User activities
 */
@Service
public class UserService {

    private final UserValidator userValidator;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserValidator userValidator, UserRepository userRepository) {
        this.userValidator = userValidator;
        this.userRepository = userRepository;
    }

    /**
     * Creates new user based on user information
     * @param user given user information
     * @return the created user
     */
    public User createUser(User user) {

        userValidator.validate(user);

        return userRepository.save(user);
    }

    public String getUserById(Integer id) {

        return userRepository.getOne(id);
    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }
}
