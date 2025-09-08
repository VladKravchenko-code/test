package ru.vlad.test.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.vlad.test.exception.response.InvalidPhoneNumberException;
import ru.vlad.test.exception.response.NotFoundException;

@Slf4j
@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleInvalidPhoneNumberException(InvalidPhoneNumberException e) {
        log.error("Throwing exception InvalidPhoneNumberException");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        log.error("Throwing exception NotFoundException");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

}
