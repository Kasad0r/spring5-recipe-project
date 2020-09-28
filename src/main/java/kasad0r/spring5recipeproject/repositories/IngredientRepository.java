package kasad0r.spring5recipeproject.repositories;

import kasad0r.spring5recipeproject.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kasad0r
 * @created 28/09/2020-17:48
 * @project spring5-recipe-project
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
