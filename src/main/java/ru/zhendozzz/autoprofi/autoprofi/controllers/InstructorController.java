package ru.zhendozzz.autoprofi.autoprofi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zhendozzz.autoprofi.autoprofi.dto.InstructorDto;
import ru.zhendozzz.autoprofi.autoprofi.dto.StudentDto;
import ru.zhendozzz.autoprofi.autoprofi.entity.Instructor;
import ru.zhendozzz.autoprofi.autoprofi.entity.Student;
import ru.zhendozzz.autoprofi.autoprofi.mapper.InstructorMapper;
import ru.zhendozzz.autoprofi.autoprofi.mapper.StudentMapper;
import ru.zhendozzz.autoprofi.autoprofi.service.InstructorService;
import ru.zhendozzz.autoprofi.autoprofi.service.StudentService;

@RestController
@RequestMapping("/api/v1/instructors")
@Tag(name = "/api/v1/instructors", description = "контроллер для инструкторов")
public class InstructorController {
    private final InstructorService instructorService;
    private final InstructorMapper instructorMapper;

    public InstructorController(InstructorService instructorService, InstructorMapper instructorMapper) {
        this.instructorService = instructorService;
        this.instructorMapper = instructorMapper;
    }

    @Operation(summary = "Получение информации по инструктору")
    @GetMapping("/{id}")
    public ResponseEntity<InstructorDto> get(@PathVariable Long id) {
        Instructor byId = instructorService.findById(id);
        return new ResponseEntity<>(instructorMapper.createUserGetResponseDto(byId), HttpStatus.OK);
    }

    @Operation(summary = "Добавление инструктора")
    @PostMapping("/")
    public ResponseEntity<Void> put(@RequestBody InstructorDto createDto) {
        instructorService.create(instructorMapper.createProjectEntity(createDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Обновление инструктора")
    @PatchMapping("/")
    public ResponseEntity<Void> update(@RequestBody InstructorDto updateDto) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Удаление инструктора")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
