package ru.vlad.test.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import ru.vlad.test.controller.UserController;
import ru.vlad.test.dto.UserDto;
import ru.vlad.test.service.UserService;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public void createNewUser(UserDto userDto) {
        log.info("POST /api/createNewUser - Creating new user with phone: {}", userDto.getPhoneNumber());
        userService.createNewUser(userDto);
    }

    @Override
    public UserDto getUserById(UUID userId) {
        log.info("GET /api/users - Search user on id: {}", userId);
        return userService.getUserById(userId);
    }

    @Override
    public void updateUser(UUID userId, UserDto userDto) {
        log.info("PUT /api/userDetailsUpdate - Update user on id: {}", userId);
        userService.updateUser(userId, userDto);
    }

    @Override
    public void deleteUser(UUID userId) {
        log.info("DELETE /api/users - Delete user on id: {}", userId);
        userService.deleteUser(userId);
    }

}
