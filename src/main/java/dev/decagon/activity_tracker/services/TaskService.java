package dev.decagon.activity_tracker.services;

import dev.decagon.activity_tracker.models.entities.Task;
import dev.decagon.activity_tracker.models.pojos.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    TaskDto create(TaskDto task);
    void delete(Long id);
    Task getTask(Long id);
    List<TaskDto> getTasks();
    TaskDto updateTitle(Long taskId, String newTitle);
    TaskDto updateDescription(Long taskId, String newDescription);
    TaskDto setPending(TaskDto task);
    TaskDto setInProgress(TaskDto task);
    TaskDto setDone(TaskDto task);
    List<TaskDto> viewAllPending(Long userId);
    List<TaskDto> viewAllInProgress(Long userId);
    List<TaskDto> viewAllDone(Long userId);
    List<TaskDto> viewAllUserTask(Long userId);


}
