package com.tawangit.agregate.controller;


import com.tawangit.agregate.entity.User;
import com.tawangit.agregate.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

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
         var user = userService.getUserById(userId);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        var users = userService.getUsersList();
        return  ResponseEntity.ok(users);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Map<String, String>> updateUser(@PathVariable("userId") String userId, @RequestBody UpdateUserDto updateUserDto) {
        userService.updateUserById(userId, updateUserDto);
        return ResponseEntity.ok(Map.of("Message", "User Updated"));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable("userId") String userId) {
         userService.deleteUserById(userId);
         return ResponseEntity.ok(Map.of("message", "Deleted"));

    }
}
