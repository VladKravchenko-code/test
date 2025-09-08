package ru.vlad.test.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.vlad.test.validation.annotation.ValidPhoneNumber;
import java.net.URL;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    @NotNull
    private String fio;

    @ValidPhoneNumber
    private String phoneNumber;

    private URL avatar;

    private UUID role;

}
