package dev.decagon.activity_tracker.models.entities;

import dev.decagon.activity_tracker.models.enums.Status;
import lombok.*;


import javax.persistence.*;
import java.util.Date;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Task")
@Table(name = "task")
public class Task  extends BaseEntity{
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

    @Column(
            name = "status"
    )
    private Status status;

    @Column(
            name = "completed_at"
    )
    private Date completedAt;

    @ManyToOne(
            targetEntity = User.class,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "User",
            referencedColumnName = "id"
    )
    private Long userId;



}



