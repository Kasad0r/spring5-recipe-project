package kasad0r.spring5recipeproject.services;

import kasad0r.spring5recipeproject.commands.IngredientCommand;
import kasad0r.spring5recipeproject.converters.IngredientToIngredientCommand;
import kasad0r.spring5recipeproject.domain.Recipe;
import kasad0r.spring5recipeproject.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author kasad0r
 * @created 28/09/2020-15:59
 * @project spring5-recipe-project
 */
@Service
public class IngredientServiceImpl implements IngredientService {
    private final RecipeRepository recipeRepository;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;

    public IngredientServiceImpl(RecipeRepository recipeRepository, IngredientToIngredientCommand ingredientToIngredientCommand) {
        this.recipeRepository = recipeRepository;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        recipeOptional.orElseThrow(RuntimeException::new);

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional =
                recipe.getIngredients()
                        .stream()
                        .filter(ingredient -> ingredient.getId().equals(ingredientId))
                        .map(ingredientToIngredientCommand::convert).findFirst();

        return ingredientCommandOptional.orElseThrow(RuntimeException::new);
    }
}
