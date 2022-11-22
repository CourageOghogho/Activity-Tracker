package dev.decagon.activity_tracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> handleNotFound(UserNotFoundException ex){
        ApiError apiError= new ApiError();
        apiError.setStatus(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        apiError.setDebugMessage(ex.getDebugMessage());

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> inValidUserInput(UserNotFoundException ex){
        ApiError apiError= new ApiError();
        apiError.setStatus(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        apiError.setDebugMessage(ex.getDebugMessage());

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
