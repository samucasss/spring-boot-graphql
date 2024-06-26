package com.samuca.graphql.springbootgraphql.repository;

import com.samuca.graphql.springbootgraphql.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, String>{
}
