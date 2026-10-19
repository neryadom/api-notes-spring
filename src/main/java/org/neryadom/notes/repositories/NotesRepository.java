package org.neryadom.notes.repositories;


import org.neryadom.notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NotesRepository extends JpaRepository<Note, UUID> {
    List<Note> findAllByTitleContaining(String title);
    List<Note> findAllByTitleContainingIgnoreCase(String title);
}


