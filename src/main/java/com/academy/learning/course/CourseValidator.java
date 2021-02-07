package com.academy.learning.course;

import com.academy.learning.exception.InvalidCourseInputException;
import com.academy.learning.model.Course;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

/**
 * Validator in charge of validating Course fields
 */
@Service
public class CourseValidator {

    /**
     * validates course fields
     * @param course given course
     */
    public void validate(Course course) {

        if (isNull(course.getName())) {
            throw new InvalidCourseInputException("Course name cannot be empty");
        }

        // TODO add more validations
    }
}
