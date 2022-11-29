package dev.decagon.activity_tracker.repositories;

import dev.decagon.activity_tracker.models.entities.Task;
import dev.decagon.activity_tracker.models.entities.User;
import dev.decagon.activity_tracker.models.enums.Gender;
import dev.decagon.activity_tracker.models.enums.Status;
import dev.decagon.activity_tracker.models.pojos.RegistrationRequest;
import dev.decagon.activity_tracker.models.pojos.TaskCreationRequest;
import dev.decagon.activity_tracker.models.pojos.TaskDto;
import dev.decagon.activity_tracker.models.pojos.UserDto;
import dev.decagon.activity_tracker.services.TaskService;
import dev.decagon.activity_tracker.services.UserService;
import dev.decagon.activity_tracker.services.imple.TaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@RunWith(SpringRunner.class)
class TaskRepositoryTest {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;
    RegistrationRequest userRegistrationRequest;


    @BeforeEach
    void setUp() {
        userRegistrationRequest=new RegistrationRequest("Tester","test@g.com",Gender.FEMALE,"password");
    }

    @Test
    void findAllUserTasks() {
        //Given
        UserDto registeredUser=userService.register(userRegistrationRequest);
        TaskDto taskDto = taskService.create(new TaskCreationRequest("My title", "For testing purpose",
                registeredUser.getId()));
        //When
        List<Task> actual=taskRepository.findAllUserTasks(taskDto.getUserId());
        //Should
        assertThat(actual.get(0).getUser().getId()).isEqualTo(taskDto.getUserId());
    }

}