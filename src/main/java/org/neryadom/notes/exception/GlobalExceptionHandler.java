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
}
