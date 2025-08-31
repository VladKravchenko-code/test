package ru.vlad.test.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.vlad.test.exception.response.InvalidPhoneNumberException;
import ru.vlad.test.exception.response.NotFoundException;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleInvalidPhoneNumberException(InvalidPhoneNumberException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

}
