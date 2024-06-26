package com.samuca.graphql.springbootgraphql.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NonNull
    private String name;

    private String description;

    @OneToMany(mappedBy = "category")
    private List<Course> courses;
}
