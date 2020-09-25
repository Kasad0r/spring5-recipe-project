package kasad0r.spring5recipeproject.converters;

import kasad0r.spring5recipeproject.commands.NotesCommand;
import kasad0r.spring5recipeproject.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author kasad0r
 * @created 24/09/2020-21:36
 * @project spring5-recipe-project
 */
@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {
    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand nc) {
        if (nc == null) return null;

        final Notes notes = new Notes();
        notes.setId(nc.getId());
        notes.setRecipeNotes(nc.getRecipeNotes());
        return notes;
    }
}
