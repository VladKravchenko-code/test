package ru.vlad.test.service;

import ru.vlad.test.dto.UserDto;
import java.util.UUID;

public interface UserService {

    void createNewUser(UserDto user);

    UserDto getUserById(UUID userID);

    void updateUser(UUID userId, UserDto dto);

    void deleteUser(UUID userId);

}
