package fr.aelion.java.springbootdemo.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Advice => notion de AOP (Aspect Oriented Programming)
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ContentNotFoundException.class)
    public ResponseEntity<ApiError> handleContentNotFoundException(GlobalException e) {
        return new ResponseEntity<>(e.toApiError(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
