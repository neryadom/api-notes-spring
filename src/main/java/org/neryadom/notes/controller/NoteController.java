package org.neryadom.notes.controller;

import org.neryadom.notes.model.Note;
import org.neryadom.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteController implements NoteControllerInterface {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @Override
    public List<Note> getNotes(Integer quantity) {
        return noteService.getNotes(quantity);
    }
}
