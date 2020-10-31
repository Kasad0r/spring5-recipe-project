package kasad0r.spring5recipeproject.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author kasad0r
 * @created 29/09/2020-15:44
 * @project spring5-recipe-project
 */
public interface ImageService {
  void saveImageFile(Long valueOf, MultipartFile file);
}
