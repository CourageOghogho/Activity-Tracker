package dev.decagon.activity_tracker.controllers;

import dev.decagon.activity_tracker.models.pojos.TaskCreationRequest;
import dev.decagon.activity_tracker.models.pojos.TaskDto;
import dev.decagon.activity_tracker.models.pojos.TaskUpdateRequest;
import dev.decagon.activity_tracker.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/new")
    public ResponseEntity<TaskDto> create(@RequestBody TaskCreationRequest request){
        return new ResponseEntity<>(taskService.create(request), HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<TaskDto> update(@RequestBody TaskUpdateRequest request){
        return new ResponseEntity<>(taskService.updateTask(request), HttpStatus.ACCEPTED);
    }

    @GetMapping("/user/all/")
    public ResponseEntity<List<TaskDto>> getMyTask(@RequestParam Long userId){
        return new ResponseEntity<>(taskService.viewAllUserTask(userId),HttpStatus.OK);
    }
    @GetMapping("/task/")
    public ResponseEntity<TaskDto> getTask(@RequestParam Long taskId){
        return new ResponseEntity<>(taskService.getTask(taskId),HttpStatus.OK);
    }

    @GetMapping("/user/done")
    public ResponseEntity<List<TaskDto>> getDoneTask(@RequestParam Long userId){
        return new ResponseEntity<>(taskService.viewAllDone(userId),HttpStatus.OK);
    }
    @GetMapping("/user/in-progress")
    public ResponseEntity<List<TaskDto>> getInProgressTask(@RequestParam Long userId){
        return new ResponseEntity<>(taskService.viewAllInProgress(userId),HttpStatus.OK);
    }
    @GetMapping("/user/pending")
    public ResponseEntity<List<TaskDto>> getPendingTask(@RequestParam Long userId){
        return new ResponseEntity<>(taskService.viewAllPending(userId),HttpStatus.OK);
    }

    @PatchMapping("/user/complete")
    public ResponseEntity<TaskDto> setTaskDone(@RequestParam Long taskId){
        return new ResponseEntity<>(taskService.setDone(taskId),HttpStatus.OK);
    }

    @PatchMapping("/user/pend")
    public ResponseEntity<TaskDto> setTaskPending(@RequestParam Long taskId){
        return new ResponseEntity<>(taskService.setPending(taskId),HttpStatus.OK);
    }
    @PatchMapping("/user/progress/")
    public ResponseEntity<TaskDto> setTaskInProgress(@RequestParam Long taskId){
        return new ResponseEntity<>(taskService.setInProgress(taskId),HttpStatus.OK);
    }

}
