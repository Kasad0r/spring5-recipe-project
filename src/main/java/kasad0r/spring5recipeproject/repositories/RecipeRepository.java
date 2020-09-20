package kasad0r.spring5recipeproject.repositories;

import kasad0r.spring5recipeproject.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kasad0r
 * @created 20/09/2020-15:01
 * @project spring5-recipe-project
 */
@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
