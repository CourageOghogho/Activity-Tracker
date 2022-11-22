package dev.decagon.activity_tracker.exceptions;

import lombok.Data;

@Data
public class EntityNotFoundException extends RuntimeException {
    private  final  String debugMessage;
    public EntityNotFoundException(String message, String debugMessage) {
        super(message);
        this.debugMessage=debugMessage;
    }
}
