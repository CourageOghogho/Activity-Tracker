package dev.decagon.activity_tracker.models.pojos;

import dev.decagon.activity_tracker.models.enums.Gender;
import lombok.Data;

@Data
public class RegistrationRequest {
    private String name;
    private String email;
    private Gender gender;
    private String password;
}
