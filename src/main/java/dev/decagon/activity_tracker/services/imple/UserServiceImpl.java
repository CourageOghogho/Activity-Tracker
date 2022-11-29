package dev.decagon.activity_tracker.services.imple;

import dev.decagon.activity_tracker.exceptions.InvalidUserDetailsException;
import dev.decagon.activity_tracker.exceptions.EntityNotFoundException;
import dev.decagon.activity_tracker.models.entities.User;
import dev.decagon.activity_tracker.models.pojos.RegistrationRequest;
import dev.decagon.activity_tracker.models.pojos.UserDto;
import dev.decagon.activity_tracker.utils.Mapper;
import dev.decagon.activity_tracker.repositories.UserRepository;
import dev.decagon.activity_tracker.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto login(String email, String password) {
        return Mapper.userToDTO(
                userRepository.findByEmailAndPassword(email,password)
                .orElseThrow(()->new EntityNotFoundException("User not found", "Enter a valid email and password")));
    }

    @Override
    public UserDto register(RegistrationRequest newUser) {

        if(newUser.getEmail()==null|| newUser.getPassword()==null||
        newUser.getName()==null|| newUser.getGender()==null) throw new InvalidUserDetailsException("Invalid Details",
                "Email, Name, Password, and Gender cannot be empty");
        return Mapper.userToDTO( userRepository.save(
                User.builder() // create user entity
                .name(newUser.getName())
                .email(newUser.getEmail())
                .gender(newUser.getGender())
                .password(newUser.getPassword())
                .build())); // persist user and return its DTO value
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user=userRepository.findByEmail(userDto.getEmail());
        if(user==null){
            throw new EntityNotFoundException("User Email update attempted","You cannot mutate user email");
        }
        user.setName(userDto.getName());
        user.setGender(userDto.getGender());

        user.setUpdatedAt(new Date()); // update last modified date

        userRepository.saveAndFlush(user); // update the user in the database

        BeanUtils.copyProperties(user,userDto); // map saved user to user dto
        return userDto;
    }

    @Override
    public UserDto getUser(Long id) {
        return Mapper.userToDTO(userRepository.findById(id).orElseThrow(
                ()->new EntityNotFoundException("User not Found","Provide valid user id")));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(Mapper::userToDTO)
                .collect(Collectors.toList());
    }
}
