package com.academy.learning.exception;

/**
 * Custom exception for invalid trainer input
 */
public class InvalidTrainerInputException extends RuntimeException {

    public InvalidTrainerInputException(String message) {

        super(message);
    }
}
