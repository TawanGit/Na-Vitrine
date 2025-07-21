package com.tawangit.agregate.service;

import com.tawangit.agregate.controller.CreateUserDto;
import com.tawangit.agregate.entity.User;
import com.tawangit.agregate.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
// padrão triple A
    // ARRANGE
    // ACT
    // ASSERT

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Nested
    class createUser {

        @Test
        @DisplayName("Should create a user with success")
        void shouldCreateAUserWithSuccess() {
            //Arrange
            var user = new User(
                UUID.randomUUID(),
                "user",
                "232",
                "123",
                        Instant.now(),
                null
            );
            doReturn(user).when(userRepository).save(any());
            var input = new CreateUserDto("taw", "sdfsdf", "12");
            //ACT
            var output = userService.createUser(input);
            //ASSERT
            assertNotNull(output);
        }

    }


}