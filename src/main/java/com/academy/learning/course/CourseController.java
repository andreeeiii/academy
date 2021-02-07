package com.academy.learning.course;

import com.academy.learning.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@EnableWebMvc
public class CourseController {

    private final CourseRepository courseRepository;

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseRepository courseRepository, CourseService courseService) {

        this.courseRepository = courseRepository;
        this.courseService = courseService;
    }

    @RequestMapping(path = "/courses", method = GET, produces = APPLICATION_JSON)
    public List<Course> getAllCourses() {

        return courseRepository.getAll();
    }

    @RequestMapping(path = "/courses", method = POST, consumes = APPLICATION_JSON)
    public void saveCourse(@RequestBody Course course) {

        courseService.save(course);
    }
}
