package kasad0r.spring5recipeproject.controllers;

import kasad0r.spring5recipeproject.commands.RecipeCommand;
import kasad0r.spring5recipeproject.repositories.RecipeRepository;
import kasad0r.spring5recipeproject.services.ImageService;
import kasad0r.spring5recipeproject.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author kasad0r
 * @created 29/09/2020-15:44
 * @project spring5-recipe-project
 */
class ImageControllerTest {

  @Mock
  ImageService imageService;

  @Mock
  RecipeService recipeService;
  @Mock
  RecipeRepository recipeRepository;

  ImageController imageController;

  MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    imageController = new ImageController(imageService, recipeService);

    mockMvc = MockMvcBuilders.standaloneSetup(imageController).build();
  }

  @Test
  void getImageForm() throws Exception {
    RecipeCommand recipeCommand = new RecipeCommand();
    recipeCommand.setId(1L);

    when(recipeService.findCommandById(anyLong())).thenReturn(recipeCommand);

    mockMvc.perform(MockMvcRequestBuilders.get("/recipe/1/image"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("recipe"));

    verify(recipeService, times(1)).findCommandById(anyLong());
  }

  @Test
  void handleImagePost() throws Exception {
    MockMultipartFile mockMultipartFile = new MockMultipartFile("imagefile", "testing.txt", "text/plain", "Kasad0r".getBytes());
    mockMvc.perform(MockMvcRequestBuilders.multipart("/recipe/1/image").file(mockMultipartFile))
            .andExpect(status().is3xxRedirection())
            .andExpect(header().string("Location", "/recipe/1/show"));
    verify(imageService, times(1)).saveImageFile(anyLong(), any());
  }
}