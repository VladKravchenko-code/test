package ru.vlad.test.mapper;

import java.net.URL;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.vlad.test.data.entity.Role;
import ru.vlad.test.data.entity.User;
import ru.vlad.test.dto.UserDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-31T13:11:48+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto dto, Role fullRole) {
        if ( dto == null && fullRole == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        if ( dto != null ) {
            user.fio( dto.getFio() );
            user.phoneNumber( dto.getPhoneNumber() );
        }
        user.role( fullRole );
        user.avatar( dto.getAvatar() != null ? dto.getAvatar() : null );

        return user.build();
    }

    @Override
    public UserDto toDto(User user, UUID id) {
        if ( user == null && id == null ) {
            return null;
        }

        String fio = null;
        String phoneNumber = null;
        URL avatar = null;
        if ( user != null ) {
            fio = user.getFio();
            phoneNumber = user.getPhoneNumber();
            avatar = user.getAvatar();
        }
        UUID role = null;
        role = id;

        UserDto userDto = new UserDto( fio, phoneNumber, avatar, role );

        return userDto;
    }

    @Override
    public void updateUserFromDto(UserDto dto, User user) {
        if ( dto == null ) {
            return;
        }

        user.setFio( dto.getFio() );
        user.setPhoneNumber( dto.getPhoneNumber() );
        user.setAvatar( dto.getAvatar() );
    }
}
