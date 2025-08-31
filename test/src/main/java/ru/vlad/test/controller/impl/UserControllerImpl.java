package ru.vlad.test.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.vlad.test.controller.UserController;
import ru.vlad.test.dto.UserDto;
import ru.vlad.test.service.UserService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    @Autowired
    private final UserService userService;

    @Override
    public void createNewUser(UserDto user) {
        userService.createNewUser(user);
    }

    @Override
    public UserDto getUserById(UUID userID) {
        return userService.getUserById(userID);
    }

    @Override
    public void updateUser(UUID userId, UserDto dto) {
        userService.updateUser(userId, dto);
    }

}
