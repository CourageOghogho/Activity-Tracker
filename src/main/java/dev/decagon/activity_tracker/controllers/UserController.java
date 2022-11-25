package dev.decagon.activity_tracker.controllers;

import dev.decagon.activity_tracker.models.pojos.RegistrationRequest;
import dev.decagon.activity_tracker.models.pojos.UserDto;
import dev.decagon.activity_tracker.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> register(@RequestBody RegistrationRequest request){
        return new ResponseEntity<>(userService.register(request), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<UserDto> update(@RequestBody UserDto user){
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<UserDto> getUser(@RequestParam Long id){
        return new ResponseEntity<>(userService.getUser(id),HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.ACCEPTED);
    }

}
