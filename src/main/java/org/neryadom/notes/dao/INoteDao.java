package org.neryadom.notes.dao;

import org.neryadom.notes.model.Note;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface INoteDao {
    List<Note> getNotes(Integer quantity);
    List<Note> getNotesByTitle(String title, boolean caseSensitive);
    Optional<Note> getNoteById(UUID id);
    UUID addNote(Note incomingNote) ;
    boolean deleteNoteById(UUID id);
}
