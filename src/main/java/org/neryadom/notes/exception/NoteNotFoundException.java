package org.neryadom.notes.exception;

public class NoteNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public NoteNotFoundException(String message) {
        super(message);
    }
}
