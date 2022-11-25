package dev.decagon.activity_tracker.controllers;

import dev.decagon.activity_tracker.models.pojos.TaskCreationRequest;
import dev.decagon.activity_tracker.models.pojos.TaskDto;
import dev.decagon.activity_tracker.models.utils.Mapper;
import dev.decagon.activity_tracker.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/")
    public ResponseEntity<TaskDto> create(@RequestBody TaskCreationRequest request){
        return new ResponseEntity<>(taskService.create(request), HttpStatus.CREATED);

    }
    {

    }
}