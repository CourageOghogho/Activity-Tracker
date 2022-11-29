package dev.decagon.activity_tracker.utils;

import dev.decagon.activity_tracker.models.entities.Task;
import dev.decagon.activity_tracker.models.entities.User;
import dev.decagon.activity_tracker.models.pojos.TaskDto;
import dev.decagon.activity_tracker.models.pojos.UserDto;

import java.util.Date;

public class Mapper {

    public  static TaskDto taskToDTOMapper(Task task){
          return TaskDto.builder()
                  .title(task.getTitle())
                  .id(task.getId())
                  .description(task.getDescription())
                  .completedAt(task.getCompletedAt())
                  .createdAt(task.getCreatedAt())
                  .status(task.getStatus())
                  .updatedAt(task.getUpdatedAt())
                  .completedAt(task.getCompletedAt())
                  .userId(task.getUser().getId())
                  .build();
    }

    public static UserDto userToDTO(User user){
        return  UserDto.builder()
                .email(user.getEmail())
                .id(user.getId())
                .gender(user.getGender())
                .name(user.getName())
                .upatedAt(user.getUpdatedAt())
                .createdAt(user.getCreatedAt())
                .upatedAt(new Date())
                .build();
    }
}
