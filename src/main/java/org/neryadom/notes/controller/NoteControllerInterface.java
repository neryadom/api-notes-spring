package org.neryadom.notes.controller;

import org.neryadom.notes.model.Note;
import org.neryadom.notes.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/notes")
public interface NoteControllerInterface {

    @GetMapping
    @ResponseBody
    List<Note> getNotes(@RequestParam(required=false, defaultValue="10") Integer quantity);

    @GetMapping("/title")
    @ResponseBody
    List<Note> getNotesByTitle(@RequestParam(required=true) String title,
                               @RequestParam(required = false, defaultValue = "true") String caseSensitive);

    @GetMapping("/{idString}")
    @ResponseBody
    Note getNoteById(@PathVariable String idString);

    @PostMapping
    @ResponseStatus
    ResponseEntity<UserResponse> addNote(@RequestBody() Note incomingNote);

    @DeleteMapping("/{id}")
    @ResponseStatus
    ResponseEntity<UserResponse> deleteNoteById(@RequestHeader("key") String key,
                                                @PathVariable("id") String id);
}
