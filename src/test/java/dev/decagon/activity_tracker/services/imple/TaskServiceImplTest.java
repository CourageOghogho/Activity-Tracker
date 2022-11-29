package dev.decagon.activity_tracker.services.imple;

import dev.decagon.activity_tracker.models.entities.Task;
import dev.decagon.activity_tracker.models.entities.User;
import dev.decagon.activity_tracker.models.enums.Gender;
import dev.decagon.activity_tracker.models.enums.Status;
import dev.decagon.activity_tracker.models.pojos.TaskCreationRequest;
import dev.decagon.activity_tracker.models.pojos.TaskDto;
import dev.decagon.activity_tracker.repositories.TaskRepository;
import dev.decagon.activity_tracker.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {
    @Mock
    TaskRepository taskRepository;

    @Mock
    UserRepository userRepository;
    @InjectMocks
    TaskServiceImpl taskService;
    TaskCreationRequest request;

    List<Task> tasks;
    User user;

    @BeforeEach
    void setUp() {
        request=new TaskCreationRequest("Test My Code", "I need to get my code tested",1L);
        user =new User(1L,"Courage","courage@g.com", Gender.MALE,"password");
        tasks =new ArrayList<>();
        tasks.add(new Task("Test My Code","I need to get my code tested", Status.DONE,
                user));
        tasks.add(new Task("Test My Code","I need to get my code tested", Status.IN_PROGRESS,
                user));
        tasks.add(new Task("Test My Code","I need to get my code tested", Status.PENDING,
                user));
        tasks.add(new Task("Test My Code","I need to get my code tested", Status.DONE,
                user));
        tasks.add(new Task("Test My Code","I need to get my code tested", Status.IN_PROGRESS,
                user));
        tasks.add(new Task("Test My Code","I need to get my code tested", Status.PENDING,
                user));
    }

    @Test
    void create() {

        when(taskRepository.save(new Task("Test My Code","I need to get my code tested", Status.PENDING,
                user))).thenReturn(new Task(1L,"Test My Code","I need to get my code tested", Status.PENDING, user));
        when(userRepository.findById(1L)).thenReturn(Optional.of((user)));
        TaskDto taskDto=taskService.create(request);
        assertEquals(taskDto.getTitle(),request.getTitle());
    }

    @Test
    void getTask() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of((new Task("Test My Code", "I need to get my code tested", Status.PENDING,
                user))));
        TaskDto taskDto=taskService.getTask(1L);
        assertEquals(taskDto.getTitle(),"Test My Code");
    }

    @Test
    void getAllTasks() {
        when(taskRepository.findAllUserTasks(1L)).thenReturn(tasks);
        assertEquals(taskService.viewAllUserTask(1L).size(), tasks.size());
    }

    @Test
    void updateTask() {
    }



    @Test
    void viewAllPending() {
        when(taskRepository.findByUserIdAndStatus(1L,"PENDING")).thenReturn(tasks.stream().filter(t->t.getStatus()==Status.PENDING).collect(Collectors.toList()));
        List<TaskDto> taskDtos=taskService.viewAllPending(1L);
        assertEquals(taskDtos.get(0).getStatus(),Status.PENDING);
    }

    @Test
    void viewAllUserTask() {
        when(taskRepository.findAllUserTasks(user.getId())).thenReturn(tasks);
        List<TaskDto> taskDtos=taskService.viewAllUserTask(user.getId());
        assertEquals(taskDtos.get(0).getUserId(), user.getId());
    }
}