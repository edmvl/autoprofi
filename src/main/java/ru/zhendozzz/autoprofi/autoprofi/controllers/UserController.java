package ru.zhendozzz.autoprofi.autoprofi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zhendozzz.autoprofi.autoprofi.dto.UserDto;
import ru.zhendozzz.autoprofi.autoprofi.mapper.UserMapper;
import ru.zhendozzz.autoprofi.autoprofi.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "/api/v1/user", description = "контроллер для пользователей")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Operation(summary = "Добавление пользователя")
    @PostMapping("/new")
    public ResponseEntity<Void> put(@RequestBody UserDto createDto) {
        userService.create(userMapper.createUserEntity(createDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
