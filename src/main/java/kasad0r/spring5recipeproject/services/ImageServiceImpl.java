package kasad0r.spring5recipeproject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author kasad0r
 * @created 29/09/2020-15:44
 * @project spring5-recipe-project
 */
@Service
@Slf4j
public class ImageServiceImpl implements ImageService {
    @Override
    public void saveImageFile(Long valueOf, MultipartFile file) {

        log.debug("Receive file");
    }
}
