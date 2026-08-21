package org.neryadom.notes.dao;

import org.neryadom.notes.model.Note;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoteDao {

    public List<Note> getNotes(Integer quantity) {
        return new ArrayList<>(List.of(new Note("Example Note", "Today is a good day"), new Note("No Content, just title")));
    }
}
