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
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(
            name = "completed_at"
    )
    @Temporal(value = TemporalType.DATE)
    private Date completedAt;

    @Column(
            name = "user_id"
    )
    private Long userId;

    public Task(String title, String description, Status status, Long userId) {
        this.title = title;
        this.description = description;
        this.status = Status.PENDING;
        this.userId = userId;
    }
}



