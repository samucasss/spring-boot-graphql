package com.samuca.graphql.springbootgraphql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NonNull
    private String name;

    private String description;

    @ManyToOne
    @NonNull
    private Category category;

}
