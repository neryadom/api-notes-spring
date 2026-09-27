package org.neryadom.notes.controller;

import org.neryadom.notes.model.Note;
import org.neryadom.notes.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteController implements NoteControllerInterface {

    private static final Logger log = LoggerFactory.getLogger(NoteController.class);
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @Override
    public List<Note> getNotes(String title, Integer quantity, String caseSensitive) {
        List<Note> output;
        output = noteService.getNotes(title, quantity, caseSensitive);
        log.info("getNotes controller called with case: {}", caseSensitive);
        return output;
    }

    @Override
    public List<Note> getNotesByTitle(String title, String caseSensitive) {
        List<Note> output;
        output = noteService.getNotesByTitle(title, caseSensitive);
        log.info("getNotesByTitle controller called with case: {}", caseSensitive);
        return output;
    }
}
