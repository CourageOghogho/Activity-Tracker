package dev.decagon.activity_tracker.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Data
@Getter
@Setter
public class ApiError {
    private HttpStatus status;
    private String message;
    private String debugMessage;
}
