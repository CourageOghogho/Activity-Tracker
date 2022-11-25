package dev.decagon.activity_tracker.services;


import dev.decagon.activity_tracker.models.pojos.TaskCreationRequest;
import dev.decagon.activity_tracker.models.pojos.TaskDto;
import dev.decagon.activity_tracker.models.pojos.TaskUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    TaskDto create(TaskCreationRequest newTask);
    void delete(Long id);
    TaskDto getTask(Long id);
    List<TaskDto> getAllTasks();
    TaskDto updateTask(TaskUpdateRequest request);
    TaskDto setPending(Long taskId);
    TaskDto setInProgress(Long taskId);
    TaskDto setDone( Long taskId);
    List<TaskDto> viewAllPending(Long userId);
    List<TaskDto> viewAllInProgress(Long userId);
    List<TaskDto> viewAllDone(Long userId);
    List<TaskDto> viewAllUserTask(Long userId);


}
