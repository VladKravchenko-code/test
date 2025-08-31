package ru.vlad.test.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlad.test.data.entity.Role;
import ru.vlad.test.data.entity.User;
import ru.vlad.test.dto.UserDto;
import ru.vlad.test.exception.constant.ErrorStatus;
import ru.vlad.test.exception.response.NotFoundException;
import ru.vlad.test.mapper.UserMapper;
import ru.vlad.test.repository.RoleRepository;
import ru.vlad.test.repository.UserRepository;
import ru.vlad.test.service.UserService;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public void createNewUser(UserDto userDto) {
        Role fullRole = roleRepository.findById(userDto.getRole())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User newUser = userMapper.toEntity(userDto, fullRole);

        userRepository.save(newUser);
    }

    @Override
    @Transactional
    public UserDto getUserById(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorStatus.NOT_FOUND_EXCEPTION.getFormattedMessage()));

        return userMapper.toDto(user, user.getRole().getUuid());
    }

    @Override
    public void updateUser(UUID userId, UserDto dto) {
        Role fullRole = roleRepository.findById(dto.getRole())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorStatus.NOT_FOUND_EXCEPTION.getFormattedMessage()));

        userMapper.updateUserFromDto(dto, user);
        user.setRole(fullRole);

        userRepository.save(user);
    }

}
