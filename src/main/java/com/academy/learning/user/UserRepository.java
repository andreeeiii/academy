package com.academy.learning.user;


import com.academy.learning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository in charge of User database interaction
 */
interface UserRepository extends JpaRepository<User, Integer> {

}
