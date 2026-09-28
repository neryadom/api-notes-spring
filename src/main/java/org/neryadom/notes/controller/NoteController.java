package org.neryadom.notes.controller;

import org.neryadom.notes.model.Note;
import org.neryadom.notes.model.UserResponse;
import org.neryadom.notes.service.NoteService;
import org.neryadom.notes.utils.AuthUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Override
    public ResponseEntity<UserResponse> addNote(Note incomingNote) {
        UserResponse ur;
        log.info("addNote controller called with new note to add of size: {}", incomingNote.getId());
        boolean output = noteService.addNote(incomingNote);
        if (output) {
            ur = new UserResponse(HttpStatus.OK, "Note successfully added");
            return new ResponseEntity<>(ur, HttpStatus.OK);
        } else {
            ur = new UserResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Note could not be added");
            return new ResponseEntity<>(ur, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<UserResponse> deleteNoteById(String key, String id) {
        UserResponse ur;
        if (!AuthUtil.canAuthenticate(key)) {
            ur = new UserResponse(HttpStatus.UNAUTHORIZED, "Unauthorized");
            return new ResponseEntity<>(ur, HttpStatus.UNAUTHORIZED);
        }
        log.info("deleteNoteById controller called with new note to delete with ID: {}", id);
        boolean output = noteService.deleteNoteById(id);
        if (output) {
            ur = new UserResponse(HttpStatus.OK, "Deleted succesfully");
            return new ResponseEntity<>(ur, HttpStatus.OK);
        }
        ur = new UserResponse(HttpStatus.NO_CONTENT, "Already deleted");
        return new ResponseEntity<>(ur, HttpStatus.NO_CONTENT);
    }
}
