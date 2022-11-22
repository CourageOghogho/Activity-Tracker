package dev.decagon.activity_tracker.exceptions;

import lombok.Data;

@Data
public class InvalidUserDetailsException extends RuntimeException {
    public InvalidUserDetailsException(String message, String debugMessage) {
    }
}
