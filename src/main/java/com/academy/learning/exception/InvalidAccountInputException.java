package com.academy.learning.exception;

/**
 * Custom exception for invalid account input
 */
public class InvalidAccountInputException extends RuntimeException {

    public InvalidAccountInputException(String message) {

        super(message);
    }
}
