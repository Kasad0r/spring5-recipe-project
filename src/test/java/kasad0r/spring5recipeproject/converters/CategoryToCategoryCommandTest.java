package kasad0r.spring5recipeproject.converters;

import kasad0r.spring5recipeproject.commands.CategoryCommand;
import kasad0r.spring5recipeproject.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kasad0r
 * @created 25/09/2020-11:15
 * @project spring5-recipe-project
 */
class CategoryToCategoryCommandTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    CategoryToCategoryCommand categoryToCategoryCommand;


    @BeforeEach
    public void setUp() {
        categoryToCategoryCommand = new CategoryToCategoryCommand();
    }

    @Test
    public void convert() {
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        //when
        CategoryCommand categoryCommand = categoryToCategoryCommand.convert(category);

        //then
        assertEquals(ID_VALUE, categoryCommand.getId());
        assertEquals(DESCRIPTION, categoryCommand.getDescription());
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(categoryToCategoryCommand.convert(new Category()));
    }

    @Test
    public void testNullObject() {
        assertNull(categoryToCategoryCommand.convert(null));
    }
}