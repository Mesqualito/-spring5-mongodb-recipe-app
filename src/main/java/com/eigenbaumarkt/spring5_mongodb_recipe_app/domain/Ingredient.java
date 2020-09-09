package com.eigenbaumarkt.spring5_mongodb_recipe_app.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
// "ingredient" wird in der mongoDB eines der in einem Array eingebetteten Objekte
// innerhalb der Collection "recipe"
public class Ingredient {

    // reliable, distinct property "id" on "Ingredient"-Objects
    // to rebuild/recover the whole "ingredient"-object array in mongodb-collection "recipe" in case of
    // Updates of "ingredient" of a "recipe" with Thymeleaf / html-POST
    private String id = UUID.randomUUID().toString();
    private String description;
    private BigDecimal amount;

    // "uom" wird in der mongoDB ein eingebettetes Objekt innerhalb der in einem Array eingebetteten Objekte
    // "ingredient" innerhalb der Collection "recipe"
    @DBRef
    private UnitOfMeasure uom;

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }

}
