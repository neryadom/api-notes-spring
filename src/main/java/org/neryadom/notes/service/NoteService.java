package org.neryadom.notes.service;

import org.neryadom.notes.utils.*;
import org.neryadom.notes.dao.NoteDao;
import org.neryadom.notes.model.Note;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        return noteDao.getNotes(quantity);
    }

    public List<Note> getNotesByTitle(String title, String caseSensitive) {
        boolean cs;

        if (!ParameterUtils.isValidCaseSensitivityParam(caseSensitive)) {
            throw new IllegalArgumentException("caseSensitive - needs to be either \"true\" or \"false\"");
        } else {
            cs = ParameterUtils.convertCaseSensitiveParamToBoolean(caseSensitive);
        }
        log.debug("getNotesByTitle with title: {} and with case: {}", title, caseSensitive);
        return noteDao.getNotesByTitle(title, cs);
    }

    public Optional<Note> getNoteById(String uuidString) {
        UUID uuid;
        try {
            uuid = UUID.fromString(uuidString);
        } catch (Exception e) {
            throw new IllegalArgumentException("idString");
        }
        return this.noteDao.getNoteById(uuid);
    }

    public UUID addNote(Note incomingNote) {
        int noteSize = incomingNote.getContent().getBytes().length;
        incomingNote.setContentSize(noteSize);
        log.info("createdNoteId: {}, createdNoteSize: {}B", incomingNote.getId(), incomingNote.getContentSize());
        return this.noteDao.addNote(incomingNote);
    }

    public boolean deleteNoteById(UUID id) {
        return noteDao.deleteNoteById(id);
    }
}
