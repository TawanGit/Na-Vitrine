package com.tawangit.agregate.service;

import com.tawangit.agregate.controller.CreateUserDto;
import com.tawangit.agregate.entity.User;
import com.tawangit.agregate.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID createUser(CreateUserDto createUserDto) {
        // DTO -> ENTITY
        var entity = new User();
        entity.setUsername(createUserDto.username());
        entity.setEmail(createUserDto.email());
        entity.setPassword(createUserDto.password());
        var userSaved = userRepository.save(entity);

        return userSaved.getUserId();
    }

}
