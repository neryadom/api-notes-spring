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

class NoteControllerTest {

    public NoteDao mockNoteDao;
    public NoteService testNoteService;
    public NoteController testNoteController;

    public List<Note> sampleData = List.of(
            new Note("Example Note", "Today is a good day"),
            new Note("No Content, just title"),
            new Note("Moving state out of a component into a file", "More to come..."),
            new Note("My takeaway from a few months of working at the university", "A lot of learning...")
    );

    @BeforeEach
    void setUp() {
        mockNoteDao = Mockito.mock(NoteDao.class) ;
        testNoteService = new NoteService(mockNoteDao);
        testNoteController = new NoteController(testNoteService);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getOneNoteReturnsFirstNote() {
        // arrange
        Note testNote = sampleData.getFirst();
        List<Note> testNoteList = List.of(testNote);
        Mockito.when(mockNoteDao.getNotes(1)).thenReturn(testNoteList);
        // act
        List<Note> result = testNoteController.getNotes(1);
        // assert
        assertEquals(result, testNoteList);
    }

    @Test
    void getOneNoteReturnsOneNote() {
        // arrange
        Note testNote = sampleData.getFirst();
        List<Note> testNoteList = List.of(testNote);
        Mockito.when(mockNoteDao.getNotes(1)).thenReturn(testNoteList);
        // act
        List<Note> result = testNoteController.getNotes(1);
        // assert
        assertEquals(1, testNoteList.size());
    }

    @Test
    void getTwoNotesReturnsTwoNotes() {
        Note testNoteOne = sampleData.get(0);
        Note testNoteTwo = sampleData.get(1);
        List<Note> testNoteList = List.of(testNoteOne, testNoteTwo);
        // arrange
        Mockito.when(mockNoteDao.getNotes(2)).thenReturn(testNoteList);
        // act
        List<Note> result = testNoteController.getNotes(2);
        // assert
        assertEquals(2, result.size());
    }
}