package org.neryadom.notes.exception;

import java.io.Serial;

public class NoteNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1;

    public NoteNotFoundException(String message) {
        super(message);
    }
}
