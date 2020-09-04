package com.eigenbaumarkt.spring5_mongodb_recipe_app.services;

import com.eigenbaumarkt.spring5_mongodb_recipe_app.commands.RecipeCommand;
import com.eigenbaumarkt.spring5_mongodb_recipe_app.domain.Recipe;

import java.util.Set;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(String l);

    RecipeCommand findCommandById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long idToDelete);
}