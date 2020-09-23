package kasad0r.spring5recipeproject.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * @author kasad0r
 * @created 20/09/2020-13:45
 * @project spring5-recipe-project
 */
@lombok.Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "categories")
   /* @JoinTable(
            name = "recipe_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )*/
    private Set<Recipe> recipes;


}
