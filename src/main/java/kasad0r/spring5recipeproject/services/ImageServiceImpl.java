package kasad0r.spring5recipeproject.services;

import kasad0r.spring5recipeproject.domain.Recipe;
import kasad0r.spring5recipeproject.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author kasad0r
 * @created 29/09/2020-15:44
 * @project spring5-recipe-project
 */
@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

  private final RecipeRepository recipeRepository;

  public ImageServiceImpl(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  @Override
  @Transactional
  public void saveImageFile(Long valueOf, MultipartFile file) {
    try {
      Recipe recipe = recipeRepository.findById(valueOf).orElseThrow();
      Byte[] byteObjects = new Byte[file.getBytes().length];
      int i = 0;
      for (byte b : file.getBytes()) {
        byteObjects[i++] = b;
      }
      recipe.setImage(byteObjects);
      recipeRepository.save(recipe);
    } catch (IOException e) {
      //todo handle better
      e.printStackTrace();
    }

    log.debug("Receive file");
  }
}
