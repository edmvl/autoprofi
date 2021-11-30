package ru.zhendozzz.autoprofi.autoprofi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zhendozzz.autoprofi.autoprofi.entity.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String login;

    private String password;

    private Role role;

}
