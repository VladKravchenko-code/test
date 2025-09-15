package ru.vlad.test.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.vlad.test.data.entity.Role;
import ru.vlad.test.data.entity.User;
import ru.vlad.test.dto.UserDto;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "role", source = "fullRole")
    @Mapping(target = "avatar", expression = "java(dto.getAvatar() != null ? dto.getAvatar() : null)")
    User toEntity(UserDto dto, Role fullRole);

    @Mapping(target = "role", source = "id")
    UserDto toDto(User user, UUID id);

    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "role", ignore = true)
    void updateUserFromDto(UserDto dto, @MappingTarget User user);

}
