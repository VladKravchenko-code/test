package ru.vlad.test.controller;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vlad.test.dto.UserDto;

import java.util.UUID;

@Validated
@RequestMapping("/api")
public interface UserController {

    @PostMapping("/createNewUser")
    void createNewUser(@RequestBody @Valid UserDto user);

    @GetMapping("users")
    UserDto getUserById(@RequestParam UUID userID);

    @PutMapping("/userDetailsUpdate")
    void updateUser(
            @RequestParam UUID userId,
            @RequestBody @Valid UserDto dto
    );

}
