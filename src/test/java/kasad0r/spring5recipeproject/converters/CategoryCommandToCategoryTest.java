package kasad0r.spring5recipeproject.converters;

import kasad0r.spring5recipeproject.commands.CategoryCommand;
import kasad0r.spring5recipeproject.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kasad0r
 * @created 25/09/2020-11:01
 * @project spring5-recipe-project
 */
class CategoryCommandToCategoryTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    CategoryCommandToCategory categoryCommandToCategory;


    @BeforeEach
    public void setUp() {
        categoryCommandToCategory = new CategoryCommandToCategory();
    }

    @Test
    public void convert() {
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        //when
        Category category = categoryCommandToCategory.convert(categoryCommand);

        //then
        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(categoryCommandToCategory.convert(new CategoryCommand()));
    }

    @Test
    public void testNullObject() {
        assertNull(categoryCommandToCategory.convert(null));
    }

}