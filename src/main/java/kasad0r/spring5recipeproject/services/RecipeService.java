package kasad0r.spring5recipeproject.services;

import kasad0r.spring5recipeproject.domain.Recipe;

import java.util.Set;

/**
 * @author kasad0r
 * @created 22/09/2020-12:26
 * @project spring5-recipe-project
 */
public interface RecipeService {
    Set<Recipe> getRecipes();
}
