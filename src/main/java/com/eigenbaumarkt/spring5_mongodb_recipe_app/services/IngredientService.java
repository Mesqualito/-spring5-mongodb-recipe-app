package com.eigenbaumarkt.spring5_mongodb_recipe_app.services;

import com.eigenbaumarkt.spring5_mongodb_recipe_app.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(String recipeId, String ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteById(String recipeId, String idToDelete);
}
