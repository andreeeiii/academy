package com.academy.learning.exception;

/**
 * Custom exception for invalid user input
 */
public class InvalidUserInputException extends RuntimeException {

    public InvalidUserInputException(String message) {

        super(message);
    }
}
