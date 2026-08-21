package org.neryadom.notes.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.neryadom.notes.dao.NoteDao;
import org.neryadom.notes.model.Note;
import org.neryadom.notes.service.NoteService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NoteControllerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNotes() {
        // arrange
        NoteDao mockNoteDao = Mockito.mock(NoteDao.class) ;
        NoteService mockNoteService = new NoteService(mockNoteDao);
        NoteController mockNoteController = new NoteController(mockNoteService);
        Note testNote = new Note("Example Note", "Today is a good day");
        List<Note> testNoteList = List.of(testNote);
        Mockito.when(mockNoteDao.getNotes(anyInt())).thenReturn(testNoteList);
        // act
        List<Note> result = mockNoteController.getNotes(1);
        // assert
        assertEquals(result, testNoteList);
    }
}