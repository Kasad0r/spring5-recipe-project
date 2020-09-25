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
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {
    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes n) {
        if (n == null) return null;

        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(n.getId());
        notesCommand.setRecipeNotes(n.getRecipeNotes());
        return notesCommand;
    }
}
