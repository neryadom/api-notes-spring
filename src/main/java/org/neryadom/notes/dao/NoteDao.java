package org.neryadom.notes.dao;

import org.neryadom.notes.exception.NoteNotFoundException;
import org.neryadom.notes.model.Note;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoteDao {

    public List<Note> storage;

    public NoteDao() {
        this.storage = new ArrayList<>();
        storage.addAll(
                List.of(
                        new Note("Example Note", "Today is a good day"),
                        new Note("No Content, just title"),
                        new Note("Moving state out of a component into a file", "More to come..."),
                        new Note("My takeaway from a few months of working at the university", "A lot of learning...")
                )
        );
    }

    public List<Note> getNotes(Integer quantity) {
        return this.storage.subList(0, Math.min(quantity, this.storage.size()));
    }

    public List<Note> getNotesByTitle(String title, boolean caseSensitivity) {
        ArrayList<Note> output = new ArrayList<>();
        for (Note n: this.storage) {
            if (n.getTitle().contains(title) || (!caseSensitivity && n.getTitle().toLowerCase().contains(title.toLowerCase()))) {
                output.add(n);
            }
        }
        if (output.isEmpty()) throw new NoteNotFoundException("Could not find notes for title: " + title);
        return output;
    }
}
