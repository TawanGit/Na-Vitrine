package com.tawangit.agregate.controller;


import com.tawangit.agregate.entity.User;
import com.tawangit.agregate.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // porta de entrada que chama a service
    // e a service chama o banco de dados.
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto){
      var userId =  userService.createUser(createUserDto);
    return ResponseEntity.created(URI.create("/v1/users/" + userId.toString())).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") String userId) {
        return null;
    }
}
