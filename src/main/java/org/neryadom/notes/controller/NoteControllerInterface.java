package org.neryadom.notes.controller;

import org.neryadom.notes.model.Note;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/notes")
public interface NoteControllerInterface {

    @GetMapping
    List<Note> getNotes(@RequestParam(required=false) String title,
                        @RequestParam(required=false, defaultValue="10") Integer quantity);

    @GetMapping("/title")
    List<Note> getNotesByTitle(@RequestParam() String title);
}
