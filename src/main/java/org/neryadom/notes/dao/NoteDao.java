package org.neryadom.notes.dao;

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
}
