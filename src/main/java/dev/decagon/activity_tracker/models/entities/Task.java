package dev.decagon.activity_tracker.models.entities;

import dev.decagon.activity_tracker.models.enums.Status;
import lombok.*;


import javax.persistence.*;
import java.util.Date;

@Entity(name ="Task")
@Table(name ="task")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(
            name = "title",
            nullable = false
    )
    private String title;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(
            name = "created_at",
            nullable = false
    )
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(
            name = "updated_at"
    )

    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    @Column(
            name = "completed_at"
    )
    @Temporal(TemporalType.DATE)
    private Date completedAt;


    @PrePersist
    public  void prePersist(){
        this.status=Status.PENDING;
        this.createdAt=new Date();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt=new Date();
    }
}
