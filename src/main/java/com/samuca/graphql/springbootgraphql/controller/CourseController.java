package com.samuca.graphql.springbootgraphql.controller;

import com.samuca.graphql.springbootgraphql.input.NewCourse;
import com.samuca.graphql.springbootgraphql.model.Category;
import com.samuca.graphql.springbootgraphql.model.Course;
import com.samuca.graphql.springbootgraphql.repository.CategoryRepository;
import com.samuca.graphql.springbootgraphql.repository.CourseRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CourseController {

    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;

    public CourseController(CourseRepository courseRepository, CategoryRepository categoryRepository) {
        this.courseRepository = courseRepository;
        this.categoryRepository = categoryRepository;
    }

    @SchemaMapping(typeName = "Query", value="courses")
    public Iterable<Course> findAll() {
        return courseRepository.findAll();
    }

    @MutationMapping
    public Course createCourse(@Argument NewCourse input) {
        Category category = categoryRepository.findById(input.categoryId()).orElse(null);
        assert category != null;

        Course course = new Course(null, input.name(), input.description(), category);
        return courseRepository.save(course);
    }
}
