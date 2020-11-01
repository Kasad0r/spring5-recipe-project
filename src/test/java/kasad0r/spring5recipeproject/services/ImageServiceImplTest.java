package kasad0r.spring5recipeproject.services;

import kasad0r.spring5recipeproject.domain.Recipe;
import kasad0r.spring5recipeproject.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * @author kasad0r
 * @created 01/11/2020-01:10
 * @project spring5-recipe-project
 */
public class ImageServiceImplTest {


  @Mock
  ImageService imageService;

  @Mock
  RecipeService recipeService;
  @Mock
  RecipeRepository recipeRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    imageService = new ImageServiceImpl(recipeRepository);

  }

  @Test
  public void saveImageFile() throws Exception {
    Long id = 1L;
    MultipartFile multipartFile = new MockMultipartFile("imagefile", "tesing.txt", "text/plain", "String java".getBytes());
    Recipe recipe = new Recipe();
    recipe.setId(id);
    Optional<Recipe> optionalRecipe = Optional.of(recipe);
    when(recipeRepository.findById(anyLong())).thenReturn(optionalRecipe);
    ArgumentCaptor<Recipe> argumentCaptor = ArgumentCaptor.forClass(Recipe.class);
    //when
    imageService.saveImageFile(id, multipartFile);

    //then
    verify(recipeRepository, times(1)).save(argumentCaptor.capture());
    Recipe savedRecipe = argumentCaptor.getValue();
    assertEquals(multipartFile.getBytes().length, savedRecipe.getImage().length);
  }

}
