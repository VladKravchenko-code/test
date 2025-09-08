package ru.vlad.test.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserMapper userMapper;

    @Override
    @Transactional
    public void createNewUser(UserDto userDto) {
        log.info("Search user in service on phone number: {}", userDto.getPhoneNumber());
        Role fullRole = roleRepository.findById(userDto.getRole())
                .orElseThrow(() -> new NotFoundException(ErrorStatus.NOT_FOUND_EXCEPTION.getFormattedMessage()));

        log.info("Convert userDto to entity in service by phone number: {}", userDto.getPhoneNumber());
        User newUser = userMapper.toEntity(userDto, fullRole);

        log.info("Save entity in service by phone number: {}", userDto.getPhoneNumber());
        userRepository.save(newUser);
    }

    @Override
    @Transactional
    public UserDto getUserById(UUID userId) {
        log.info("Search user in service on userId: {}", userId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorStatus.NOT_FOUND_EXCEPTION.getFormattedMessage()));

        log.info("Convert entity to userDto in service by userId: {}", userId);
        return userMapper.toDto(user, user.getRole().getUuid());
    }

    @Override
    @Transactional
    public void updateUser(UUID userId, UserDto userDto) {
        log.info("Search role in service on roleId: {}", userDto.getRole());
        Role fullRole = roleRepository.findById(userDto.getRole())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        log.info("Found a role. Search user in service on userId: {}", userId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorStatus.NOT_FOUND_EXCEPTION.getFormattedMessage()));

        log.info("Convert userDto to entity and set role for userId: {}", userId);
        userMapper.updateUserFromDto(userDto, user);
        user.setRole(fullRole);

        log.info("Save entity in service by userId: {}", userId);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(UUID userId) {
        log.info("Search user in service on userId: {}", userId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorStatus.NOT_FOUND_EXCEPTION.getFormattedMessage()));

        log.info("Delete user in service on userId: {}", userId);
        userRepository.delete(user);
    }

}
