package kasad0r.spring5recipeproject.services;

import kasad0r.spring5recipeproject.commands.IngredientCommand;

/**
 * @author kasad0r
 * @created 28/09/2020-15:59
 * @project spring5-recipe-project
 */
public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand ingredientCommand);
}
