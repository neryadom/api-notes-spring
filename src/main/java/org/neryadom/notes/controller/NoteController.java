package org.neryadom.notes.controller;

import org.neryadom.notes.model.Note;
import org.neryadom.notes.model.UserResponse;
import org.neryadom.notes.service.NoteService;
import org.neryadom.notes.utils.AuthUtils;
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
    public List<Note> getNotes(Integer quantity) {
        List<Note> output;
        output = noteService.getNotes(quantity);
        log.debug("method: GET, controller: /notes, quantity: {}", quantity);
        return output;
    }

    @Override
    public List<Note> getNotesByTitle(String title, String caseSensitive) {
        List<Note> output;
        output = noteService.getNotesByTitle(title, caseSensitive);
        log.debug("method: GET, controller: /notes/{}, caseSensitive: {}", title, caseSensitive);
        return output;
    }

    @Override
    public ResponseEntity<UserResponse> addNote(Note incomingNote) {
        UserResponse ur;
        log.debug("method: POST, controller: /notes, size: {}", incomingNote.getId());
        boolean addSuccess = noteService.addNote(incomingNote);
        if (addSuccess) {
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
        if (!AuthUtils.canAuthenticate(key)) {
            ur = new UserResponse(HttpStatus.UNAUTHORIZED, "Unauthorized");
            return new ResponseEntity<>(ur, HttpStatus.UNAUTHORIZED);
        }
        log.debug("method: DELETE, controller: /notes/{}", id);
        boolean output = noteService.deleteNoteById(id);
        if (output) {
            ur = new UserResponse(HttpStatus.OK, "Deleted succesfully");
            return new ResponseEntity<>(ur, HttpStatus.OK);
        }
        ur = new UserResponse(HttpStatus.NO_CONTENT, "Already deleted");
        return new ResponseEntity<>(ur, HttpStatus.NO_CONTENT);
    }
}
