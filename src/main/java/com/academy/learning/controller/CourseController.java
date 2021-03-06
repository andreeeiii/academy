package com.academy.learning.controller;

import com.academy.learning.model.Course;
import com.academy.learning.repository.CourseRepository;
import com.academy.learning.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@RestController
@EnableWebMvc
@CrossOrigin(value = "*")
public class CourseController {

    private final CourseRepository courseRepository;

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseRepository courseRepository, CourseService courseService) {

        this.courseRepository = courseRepository;
        this.courseService = courseService;
    }

    @GetMapping(path = "/courses", produces = APPLICATION_JSON)
    public List<Course> getAllCourses() {

        return courseRepository.getAll();
    }

    @PostMapping(path = "/courses", consumes = APPLICATION_JSON)
    public Course saveCourse(@RequestBody Course course) {

        return courseService.save(course);
    }

    @GetMapping(path = "/courses/{name}", produces = APPLICATION_JSON)
    public String getCourseByName(@PathVariable String name) {

        return courseService.getByName(name);
    }
}
