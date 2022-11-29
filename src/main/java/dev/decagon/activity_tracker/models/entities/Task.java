package dev.decagon.activity_tracker.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "taskk")
public class Task  extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToOne(targetEntity = User.class)
    @JsonIgnore
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "task_user_id_fk"
            )
    )
    private User user;

    public Task(String title, String description, Status status, User user) {
        this.title = title;
        this.description = description;
        this.status = Status.PENDING;
        this.user = user;
    }

    public Task(Long id, String title, String description, Status status, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.user = user;
    }
}



