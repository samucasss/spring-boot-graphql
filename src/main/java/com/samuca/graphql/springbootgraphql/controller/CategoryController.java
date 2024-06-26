package com.samuca.graphql.springbootgraphql.controller;

import com.samuca.graphql.springbootgraphql.input.NewCategory;
import com.samuca.graphql.springbootgraphql.model.Category;
import com.samuca.graphql.springbootgraphql.repository.CategoryRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @SchemaMapping(typeName = "Query", value="categories")
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @MutationMapping
    public Category createCategory(@Argument NewCategory input) {
        Category category = new Category(null, input.name(), input.description(), null);
        return categoryRepository.save(category);
    }
}
