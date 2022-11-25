package dev.decagon.activity_tracker.models.pojos;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class TaskUpdateRequest {
    private Long taskId;
    private String title;
    private String description;
    private Long userId;

    public TaskUpdateRequest(Long taskId, String title, String description, Long userId) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.userId = userId;
    }
}
