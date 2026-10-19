package org.neryadom.notes.service;

import org.neryadom.notes.utils.*;
import org.neryadom.notes.dao.NoteDao;
import org.neryadom.notes.model.Note;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NoteService {

    private final NoteDao noteDao;
    private static final Logger log = LoggerFactory.getLogger(NoteService.class);

    @Autowired
    public NoteService(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public List<Note> getNotes(Integer quantity) {
        List<Note> output;
        output = noteDao.getNotes(quantity);
        return output.subList(0, Math.min(quantity, output.size()));
    }

    public List<Note> getNotesByTitle(String title, String caseSensitive) {
        boolean cs;

        if (!ParameterUtils.isValidCaseSensitivityParam(caseSensitive)) {
            throw new IllegalArgumentException("caseSensitive parameter needs to be either \"true\" or \"false\"");
        } else {
            cs = ParameterUtils.convertCaseSensitiveParamToBoolean(caseSensitive);
        }
        log.debug("getNotesByTitle with title: {} and with case: {}", title, caseSensitive);
        return noteDao.getNotesByTitle(title, cs);
    }

    public boolean addNote(Note incomingNote) {
        return this.noteDao.addNote(incomingNote);
    }

    public boolean deleteNoteById(UUID id) {
        return noteDao.deleteNoteById(id);
    }
}
