package kasad0r.spring5recipeproject.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author kasad0r
 * @created 24/09/2020-20:24
 * @project spring5-recipe-project
 */
@Getter
@Setter
@NoArgsConstructor
public class CategoryCommand {
    private Long id;
    private String description;
}
