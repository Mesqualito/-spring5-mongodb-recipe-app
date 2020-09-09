package com.eigenbaumarkt.spring5_mongodb_recipe_app.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
// "notes" wird in der mongoDB ein eingebettetes Objekt innerhalb der Collection "recipe"
public class Notes {

    @Id
    private String id;
    private String recipeNotes;
}
