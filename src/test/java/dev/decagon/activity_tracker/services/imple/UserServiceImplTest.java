package dev.decagon.activity_tracker.services.imple;

import dev.decagon.activity_tracker.models.entities.User;
import dev.decagon.activity_tracker.models.enums.Gender;
import dev.decagon.activity_tracker.models.pojos.RegistrationRequest;
import dev.decagon.activity_tracker.models.pojos.UserDto;
import dev.decagon.activity_tracker.repositories.UserRepository;
import dev.decagon.activity_tracker.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    User user;
    RegistrationRequest request;
    @InjectMocks
    UserServiceImpl userService;
    @Mock
    UserRepository userRepository;
    @BeforeEach
    void setUp() {
        user=new User("Courage","courage@g.com", Gender.MALE,"password");
        request=new RegistrationRequest("Courage","courage@g.com", Gender.MALE,"password");
    }

    @Test
    void register() {
        when(userRepository.save(user)).thenReturn(new User(1L,"Courage","courage@g.com",
                Gender.MALE,"password"));
        UserDto savedUser=userService.register(request);
        assertEquals(savedUser.getEmail(),request.getEmail());
    }
}