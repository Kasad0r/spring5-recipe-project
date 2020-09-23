package kasad0r.spring5recipeproject.domain;

import javax.persistence.*;

/**
 * @author kasad0r
 * @created 17/09/2020-14:37
 * @project spring5-recipe-project
 */
@lombok.Data
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Recipe recipe;
    @Lob
    private String recipeNotes;

}
