package dev.decagon.activity_tracker.models.utils;

import dev.decagon.activity_tracker.models.entities.Task;
import dev.decagon.activity_tracker.models.entities.User;
import dev.decagon.activity_tracker.models.pojos.TaskDto;
import dev.decagon.activity_tracker.models.pojos.UserDto;

import java.util.Date;

public class Mapper {

    public  static TaskDto taskToDTOMaper(Task task){
          return TaskDto.builder()
                  .title(task.getTitle())
                  .id(task.getId())
                  .description(task.getDescription())
                  .completedAt(task.getCompletedAt())
                  .createdAt(task.getCreatedAt())
                  .status(task.getStatus())
                  .build();
    }

    public static UserDto userToDTO(User user){
        return  UserDto.builder()
                .email(user.getEmail())
                .id(user.getId())
                .gender(user.getGender())
                .name(user.getName())
                .createdAt(user.getCreatedAt())
                .upatedAt(new Date())
                .build();
    }
}
