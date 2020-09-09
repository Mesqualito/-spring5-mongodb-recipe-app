package com.eigenbaumarkt.spring5_mongodb_recipe_app.services;

import com.eigenbaumarkt.spring5_mongodb_recipe_app.commands.RecipeCommand;
import com.eigenbaumarkt.spring5_mongodb_recipe_app.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(String id);

    RecipeCommand findCommandById(String id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(String idToDelete);
}
