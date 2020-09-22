package kasad0r.spring5recipeproject.repositories;

import kasad0r.spring5recipeproject.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author kasad0r
 * @created 20/09/2020-15:03
 * @project spring5-recipe-project
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);

}
