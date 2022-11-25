package dev.decagon.activity_tracker.models.utils;

import dev.decagon.activity_tracker.models.entities.Task;
import dev.decagon.activity_tracker.models.pojos.TaskDto;

public class Mapper {

    public  static TaskDto taskToDTOMaper(Task task){
          return TaskDto.builder()
//                  .title(task.getTitle())
//                  .id(task.getId())
//                  .description(task.getDescription())
//                  .completedAt(task.getCompletedAt())
//                  .createdAt(task.getCreatedAt())
//                  .status(task.getStatus())
                  .build();
    }
}
