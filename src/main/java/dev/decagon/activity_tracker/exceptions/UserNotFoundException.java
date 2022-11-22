package dev.decagon.activity_tracker.exceptions;

import lombok.Data;

@Data
public class UserNotFoundException extends RuntimeException {
    private  final  String debugMessage;
    public UserNotFoundException(String message, String debugMessage) {
        super(message);
        this.debugMessage=debugMessage;
    }
}
