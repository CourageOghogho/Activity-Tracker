package dev.decagon.activity_tracker.exceptions;

public class IllegalEntityStateException extends RuntimeException {
    private  final String debugMessage;
    public IllegalEntityStateException(String message, String debugMessage) {
        super(message);
        this.debugMessage=debugMessage;
    }
}
