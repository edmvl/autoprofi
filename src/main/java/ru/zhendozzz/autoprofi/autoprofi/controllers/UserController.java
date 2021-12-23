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
import ru.zhendozzz.autoprofi.autoprofi.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "/api/v1/user", description = "контроллер для пользователей")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Добавление пользователя")
    @PostMapping("/")
    public ResponseEntity<Void> add(@RequestBody UserDto createDto) {
        userService.create(createDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
