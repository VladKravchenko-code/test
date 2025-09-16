package ru.vlad.test.service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vlad.test.data.entity.Role;
import ru.vlad.test.data.entity.User;
import ru.vlad.test.dto.UserDto;
import ru.vlad.test.mapper.UserMapper;
import ru.vlad.test.repository.RoleRepository;
import ru.vlad.test.repository.UserRepository;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@SpringBootTest
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    private static final UUID uuidUser = UUID.fromString("111d4111-1111-1110-1111-00a0c91e6bf6");

    private static final UUID uuidRole = UUID.fromString("f81d4fae-7dec-11d0-a765-00a0c91e6bf6");

    private static final String userFio = "Bob Bob Bob";

    private static final String userPhone = "71234567890";

    private static UserDto userDtoForTest;

    private static User userTest;

    private static URL urlForTestDto;

    private static Role fullRoleTest;

    @BeforeAll
    static void init() throws MalformedURLException {

        urlForTestDto = new URL("http://example.com/path/to/resource");

        userTest = User
                .builder()
                .uuid(uuidUser)
                .fio(userFio)
                .phoneNumber(userPhone)
                .avatar(urlForTestDto)
                .role(fullRoleTest)
                .build();

        userDtoForTest = UserDto
                .builder()
                .fio(userFio)
                .phoneNumber(userPhone)
                .avatar(urlForTestDto)
                .role(uuidRole)
                .build();

        fullRoleTest = Role
                .builder()
                .uuid(uuidRole)
                .users(Collections.singletonList(userTest))
                .build();

    }

    @Test
    void createNewUserTest() {
        when(roleRepository.findById(uuidRole)).thenReturn(Optional.of(fullRoleTest));
        when(userMapper.toEntity(userDtoForTest, fullRoleTest)).thenReturn(userTest);
        when(userRepository.save(userTest)).thenReturn(userTest);

        userService.createNewUser(userDtoForTest);

        verify(roleRepository, times(1)).findById(userDtoForTest.getRole());
        verify(userMapper, times(1)).toEntity(userDtoForTest, fullRoleTest);
        verify(userRepository, times(1)).save(userTest);

    }

}
