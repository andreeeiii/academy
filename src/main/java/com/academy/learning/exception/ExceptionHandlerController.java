package com.academy.learning.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidAccountInputException.class)
    protected ResponseEntity<Object> handleInvalidAccountInputException(InvalidAccountInputException e, WebRequest req) {

        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), BAD_REQUEST, req);
    }

    @ExceptionHandler(InvalidCourseInputException.class)
    protected ResponseEntity<Object> handleInvalidCourseInputException(InvalidCourseInputException e, WebRequest req) {

        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), BAD_REQUEST, req);
    }

    @ExceptionHandler(InvalidTrainerInputException.class)
    protected ResponseEntity<Object> handleInvalidTrainerInputException(InvalidTrainerInputException e, WebRequest req) {

        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), BAD_REQUEST, req);
    }

    // TODO treat Membership wrong value path
    @ExceptionHandler(InvalidUserInputException.class)
    protected ResponseEntity<Object> handleInvalidUserInputException(InvalidUserInputException e, WebRequest req) {

        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), BAD_REQUEST, req);
    }
}
