package org.neryadom.notes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoteNotFoundException.class)
    public ResponseEntity<ErrorObject> handleNoteNotFound(NoteNotFoundException ex) {
        ErrorObject er = new ErrorObject();
        er.statusCode = HttpStatus.NOT_FOUND.value();
        er.errorMessage = "Note not found: " + ex.getMessage();
        er.timestamp = new Date();

        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorObject> handleIllegalArgument(IllegalArgumentException ex) {
        ErrorObject er = new ErrorObject();
        er.statusCode = HttpStatus.BAD_REQUEST.value();
        er.errorMessage = "Check parameters for: " + ex.getMessage();
        er.timestamp = new Date();

        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }
}
