package dev.decagon.activity_tracker.services.imple;

import dev.decagon.activity_tracker.exceptions.UserNotFoundEXception;
import dev.decagon.activity_tracker.models.entities.Login;
import dev.decagon.activity_tracker.models.entities.User;
import dev.decagon.activity_tracker.models.pojos.RegistrationRequest;
import dev.decagon.activity_tracker.models.pojos.UserDto;
import dev.decagon.activity_tracker.repositories.LoginRepository;
import dev.decagon.activity_tracker.repositories.UserRepository;
import dev.decagon.activity_tracker.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class UserServiceImpl implements UserService {

    private final LoginRepository loginRepository;
    private  final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(LoginRepository loginRepository, UserRepository userRepository) {
        this.loginRepository = loginRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto login(String email, String password) {

        Login login = loginRepository.findByEmailAndPassword(email, password) // confirm if the user login details is correct
                .orElseThrow(()->new UserNotFoundEXception("User not found"));
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(userRepository.findByEmail(email),userDto); // get the user details and map to dto
        return userDto;
    }

    @Override
    public UserDto register(RegistrationRequest newUser) {
        User user= User.builder() // create user entity
                .name(newUser.getName())
                .email(newUser.getEmail())
                .gender(newUser.getGender())
                .build();

        Login login=Login.builder()  // create login details entity
                .email(newUser.getEmail())
                .password(newUser.getPassword())
                .build();

        userRepository.save(user); // persist user
        loginRepository.save(login); //  persist login for the user

        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(user,userDto); // map saved user to user dto

        return userDto;
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user=userRepository.findByEmail(userDto.getEmail());
        if(user==null){
            throw new UserNotFoundEXception("You cannot mutate user email");
        }
        user.setName(userDto.getName());
        user.setGender(userDto.getGender());

        user.setUpdatedAt(new Date()); // update last modified date

        userRepository.saveAndFlush(user); // update the user in the database

        BeanUtils.copyProperties(user,userDto); // map saved user to user dto
        return userDto;
    }
}
