package org.neryadom.notes.service;

import org.neryadom.notes.dao.NoteDao;
import org.neryadom.notes.model.Note;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteDao noteDao;
    private static final Logger log = LoggerFactory.getLogger(NoteService.class);

    @Autowired
    public NoteService(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public List<Note> getNotes(String title, Integer quantity, String caseSensitivity) {
        List<Note> output;
        if (caseSensitivity.equalsIgnoreCase("false")) {
            title = title.toLowerCase();
        } else if (!caseSensitivity.equalsIgnoreCase("true")) {
            throw new IllegalArgumentException("Case sensitivity needs to be either \"true\" or \"false\"");
        }
        if (title != null) {
            log.info("getNotesByTitle with title: {} and with quantity: {} and with case: {}", title, quantity, caseSensitivity);
            output = this.getNotesByTitle(title, caseSensitivity);
        } else {
            output = noteDao.getNotes(quantity);
        }
        return output.subList(0, Math.min(quantity, output.size()));
    }

    public List<Note> getNotesByTitle(String title, String caseSensitivity) {
        boolean cs = true;
        if (caseSensitivity.equalsIgnoreCase("false")) {
            cs = false;
            title = title.toLowerCase();
        } else if (!caseSensitivity.equalsIgnoreCase("true")) {
            throw new IllegalArgumentException("Case sensitivity needs to be either \"true\" or \"false\"");
        }
        return noteDao.getNotesByTitle(title, cs);
    }
}
