package ru.vlad.test.controller;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.vlad.test.dto.UserDto;
import java.util.UUID;

@Validated
@RequestMapping("/api")
public interface UserController {

    @PostMapping("/createNewUser")
    void createNewUser(@RequestBody @Valid UserDto userDto);

    @GetMapping("/users")
    UserDto getUserById(@RequestParam UUID userId);

    @PutMapping("/userDetailsUpdate")
    void updateUser(
            @RequestParam UUID userId,
            @RequestBody @Valid UserDto userDto
    );

    @DeleteMapping("/users")
    void deleteUser(@RequestParam UUID userId);

}
