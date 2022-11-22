package dev.decagon.activity_tracker.models.entities;

import lombok.*;

import javax.persistence.*;

@Entity(name="Login")
@Table(name="login")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(
            name="email",
            unique = true,
            updatable = false
    )
    private String email;
    @Column(name="password")
    private String password;

}
