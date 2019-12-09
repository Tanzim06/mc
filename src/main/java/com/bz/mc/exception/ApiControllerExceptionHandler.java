package com.bz.mc.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * User: rafiq
 * Date: 26/11/19
 * Time: 12:57 AM
 */
@Log4j2
@RestControllerAdvice
public class ApiControllerExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<String> handleConflict(ApiException ex) {
        log.error(ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleConflict(Exception ex) {
        log.error(ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleConflict(NotFoundException ex) {
        log.error(ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
