package org.neryadom.notes.dao;

import lombok.extern.slf4j.Slf4j;
import org.neryadom.notes.model.Note;
import org.neryadom.notes.repositories.NotesRepository;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class NoteDao implements INoteDao{

    private final NotesRepository notesRepository;


    public NoteDao(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
        // this.populate()
    }

    public List<Note> getNotes(Integer quantity) {
        return notesRepository.findAll(PageRequest.of(0, quantity)).stream().toList();
    }

    public List<Note> getNotesByTitle(String title, boolean caseSensitive) {
        if (caseSensitive) {
            return this.notesRepository.findAllByTitleContaining(title);
        } else {
            return this.notesRepository.findAllByTitleContainingIgnoreCase(title);
        }
    }

    public UUID addNote(Note incomingNote) {
        var value = this.notesRepository.save(incomingNote);
        return value.getId();
    }

    public boolean deleteNoteById(UUID id) {
        try {
            this.notesRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void populate() {
        var storage = List.of(
                new Note("Example Note", "Today is a good day"),
                new Note("No Content, just title"),
                new Note("Moving state out of a component into a file", "More to come..."),
                new Note("My takeaway from a few months of working at the university", "A lot of learning...")
        );
        for (Note n: storage) {
            this.addNote(n);
        }
    }
}
