package com.eigenbaumarkt.spring5_mongodb_recipe_app.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Getter
@Setter
@Document
public class Category {

    @Id
    private String id;
    private String description;

    // "categories" wird innerhalb der mongoDB in der Collection "recipe"
    // ein Array mit Referenzen auf Datensätze in der Collection "category"
    @DBRef
    private Set<Recipe> recipes;
}
