package kasad0r.spring5recipeproject.commands;

import kasad0r.spring5recipeproject.domain.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author kasad0r
 * @created 24/09/2020-20:23
 * @project spring5-recipe-project
 */
@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {
    private Long id;
    private Recipe recipe;
    private String recipeNotes;
}
