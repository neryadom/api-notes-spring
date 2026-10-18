package org.neryadom.notes.dao;

import org.neryadom.notes.model.Note;

import java.util.List;

public interface INoteDao {
    public List<Note> getNotes(Integer quantity);
    public List<Note> getNotesByTitle(String title, boolean caseSensitivity);
    public boolean addNote(Note incomingNote) ;
    public boolean deleteNoteById(String id);
}
