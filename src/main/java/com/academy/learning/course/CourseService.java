package com.academy.learning.course;

import com.academy.learning.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Interface in charge of {@link Course} operations
 */
@Service
public class CourseService {

    private final CourseValidator courseValidator;
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseValidator courseValidator, CourseRepository courseRepository) {

        this.courseValidator = courseValidator;
        this.courseRepository = courseRepository;
    }

    public Course save(Course course) {

        courseValidator.validate(course);

        return courseRepository.save(course);
    }
}
