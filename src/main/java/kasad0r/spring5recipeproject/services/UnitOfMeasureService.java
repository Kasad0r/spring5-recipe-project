package kasad0r.spring5recipeproject.services;

import kasad0r.spring5recipeproject.commands.UnitOfMeasureCommand;

import java.util.Set;

/**
 * @author kasad0r
 * @created 28/09/2020-18:01
 * @project spring5-recipe-project
 */
public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> findAll();
}
