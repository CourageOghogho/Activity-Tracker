package dev.decagon.activity_tracker.models.pojos;

import dev.decagon.activity_tracker.models.enums.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private  Long id;
    private String name;
    private String email;
    private Gender gender;
    private Date createdAt;
    private Date upatedAt;
}
