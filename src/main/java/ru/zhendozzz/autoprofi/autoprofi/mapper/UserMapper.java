package ru.zhendozzz.autoprofi.autoprofi.mapper;

import org.springframework.stereotype.Component;
import ru.zhendozzz.autoprofi.autoprofi.dto.UserDto;
import ru.zhendozzz.autoprofi.autoprofi.entity.User;

@Component
public class UserMapper {
    public static UserDto createUserGetResponseDto(User byId) {
        return UserDto.builder()
            .id(byId.getId())
            .login(byId.getLogin())
            .password(byId.getPassword())
            .role(byId.getRole())
            .build();
    }

    public static User createUserEntity(UserDto createDto) {
        return User.builder()
            .id(createDto.getId())
            .login(createDto.getLogin())
            .password(createDto.getPassword())
            .role(createDto.getRole())
            .build();
    }
}
