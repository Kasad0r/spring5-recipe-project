package kasad0r.spring5recipeproject.domain;

import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author kasad0r
 * @created 17/09/2020-15:16
 * @project spring5-recipe-project
 */
@lombok.Data
@ToString(exclude = {"recipe"})
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure unitOfMeasure;

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure) {
        this.description = description;
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
        this.recipe = recipe;
    }

    public Ingredient() {
    }

    @ManyToOne
    private Recipe recipe;

}
