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
    public List<Note> getNotes(String title, Integer quantity) {
        List<Note> output;
        if (title == null) {
            log.info("getNotes with all titles and with quantity: {}", quantity);
            return noteService.getNotes(quantity);
        }
        output = noteService.getNotesByTitle(title);
        log.info("getNotes with title: {} and with quantity: {}", title, quantity);
        return output.subList(0, Math.min(quantity, output.size()));
    }

    @Override
    public List<Note> getNotesByTitle(String title) {
        List<Note> output;
        output = noteService.getNotesByTitle(title);
        log.info("getNotesByTitle with title: {}", title);
        return output;
    }
}
