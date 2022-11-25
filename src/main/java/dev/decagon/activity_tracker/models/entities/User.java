package dev.decagon.activity_tracker.models.entities;
import dev.decagon.activity_tracker.models.enums.Gender;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "User")
@Table(name = "user")
public class User  extends BaseEntity{
    @Id
    @Column(
            name = "id"
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(
            name = "name",
            nullable = false
    )
    private String name;
    @Column(
            name = "email",
            nullable = false,
            unique = true
    )
    private String email;

    @Column(
            name = "gender",
            nullable = false
    )
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(
            name = "password",
            nullable = false
    )
    private String password;

    public User(String name, String email, Gender gender,String password) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.password=password;
    }
}
