package com.samuca.graphql.springbootgraphql.repository;

import com.samuca.graphql.springbootgraphql.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
}
