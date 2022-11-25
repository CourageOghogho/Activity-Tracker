package dev.decagon.activity_tracker.models.pojos;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
public class TaskCreationRequest {
    private String title;
    private String description;
    private Long userId;

    public TaskCreationRequest(String title, String description, Long userId) {
        this.title = title;
        this.description = description;
        this.userId = userId;
    }
}

