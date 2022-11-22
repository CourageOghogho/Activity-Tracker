package dev.decagon.activity_tracker.services;

import dev.decagon.activity_tracker.models.entities.User;
import dev.decagon.activity_tracker.models.pojos.RegistrationRequest;
import dev.decagon.activity_tracker.models.pojos.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDto login(String email, String password);

    UserDto register(RegistrationRequest newUser);

    UserDto update(UserDto userDto);
}
