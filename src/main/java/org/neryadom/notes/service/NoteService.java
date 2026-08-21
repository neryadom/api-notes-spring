package org.neryadom.notes.service;

import org.neryadom.notes.dao.NoteDao;
import org.neryadom.notes.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteDao noteDao;

    @Autowired
    public NoteService(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public List<Note> getNotes(Integer quantity) {
        return noteDao.getNotes(quantity);
    }
}
