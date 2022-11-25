package dev.decagon.activity_tracker.services;

import dev.decagon.activity_tracker.models.enums.Status;
import dev.decagon.activity_tracker.models.pojos.TaskCreationRequest;
import dev.decagon.activity_tracker.models.pojos.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    TaskDto create(TaskCreationRequest newTask);
    void delete(Long id);
    TaskDto getTask(Long id);
    List<TaskDto> getAllTasks();
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
