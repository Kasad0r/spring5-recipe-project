package kasad0r.spring5recipeproject.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * @author kasad0r
 * @created 20/09/2020-13:45
 * @project spring5-recipe-project
 */
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
