package com.academy.learning.exception;

import com.academy.learning.exception.InvalidAccountInputException;
import com.academy.learning.exception.InvalidCourseInputException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class CourseExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidCourseInputException.class)
    protected ResponseEntity<Object> handleInvalidCourseInputException(InvalidCourseInputException e, WebRequest req) {

        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), BAD_REQUEST, req);
    }
}
