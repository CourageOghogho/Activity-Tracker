package dev.decagon.activity_tracker.models.pojos;

import dev.decagon.activity_tracker.models.enums.Gender;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
public class UserDto {
    private  Long id;
    private String name;
    private String email;
    private Gender gender;
    private Date createdAt;
    private Date upatedAt;

    public UserDto(Long id, String name, String email, Gender gender, Date createdAt, Date upatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.createdAt = createdAt;
        this.upatedAt = upatedAt;
    }
}
