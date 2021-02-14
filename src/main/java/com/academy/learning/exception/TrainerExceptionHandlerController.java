package com.academy.learning.exception;

import com.academy.learning.exception.InvalidTrainerInputException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
//TODO: global exception catcher
@RestControllerAdvice
public class TrainerExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidTrainerInputException.class)
    protected ResponseEntity<Object> handleInvalidTrainerInputException(InvalidTrainerInputException e, WebRequest req) {

        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), BAD_REQUEST, req);
    }
}
