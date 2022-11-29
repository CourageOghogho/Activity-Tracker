package dev.decagon.activity_tracker.models.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.decagon.activity_tracker.models.enums.Gender;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "User")
@Table(name = "userr")
public class User  extends BaseEntity{
    @Id
    @Column(
            name = "id"
    )
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @JsonIgnore
    @OneToMany(
            mappedBy = "user",
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Task> task;

    public User(String name, String email, Gender gender,String password) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.password=password;
    }

    public User(Long id, String name, String email, Gender gender, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.password = password;
    }
}
