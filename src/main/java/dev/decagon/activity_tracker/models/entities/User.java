package dev.decagon.activity_tracker.models.entities;

import dev.decagon.activity_tracker.models.enums.Gender;
import dev.decagon.activity_tracker.models.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "User")
@Table(name="user")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(
            name = "id",
            updatable = false,
            nullable = false
    )
    private Long id;

    @Column(
            name = "first_name",
            nullable = false
    )
    private  String name;

    @Column(
            name = "email",
            unique = true,
            nullable = false,
            updatable = false
    )
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToOne
    @JoinColumn(
        name = "login", referencedColumnName = "log_id"
    )
    private Login login;

    @Column(
            name = "created_at"
    )

    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(
            name = "updated_at"
    )

    @Temporal(TemporalType.DATE)
    private Date updatedAt;



    @PrePersist
    public  void prePersist(){
        this.createdAt=new Date();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt=new Date();
    }


}
