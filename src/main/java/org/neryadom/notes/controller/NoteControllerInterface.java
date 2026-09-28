package org.neryadom.notes.controller;

import org.apache.catalina.User;
import org.apache.coyote.Response;
import org.neryadom.notes.model.Note;
import org.neryadom.notes.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/notes")
public interface NoteControllerInterface {

    @GetMapping
    List<Note> getNotes(@RequestParam(required=false) String title,
                        @RequestParam(required=false, defaultValue="10") Integer quantity,
                        @RequestParam(required=false, defaultValue="true") String caseSensitive);

    @GetMapping("/title")
    List<Note> getNotesByTitle(@RequestParam() String title,
                               @RequestParam(required = false, defaultValue = "true") String caseSensitive);

    @PostMapping
    ResponseEntity<UserResponse> addNote(@RequestBody() Note incomingNote);

    @DeleteMapping("/{id}")
    ResponseEntity<UserResponse> deleteNoteById(@RequestHeader("key") String key,
                                                @PathVariable("id") String id);
}
