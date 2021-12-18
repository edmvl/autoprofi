package ru.zhendozzz.autoprofi.autoprofi.controllers;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
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
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.zhendozzz.autoprofi.autoprofi.dto.StudentDto;
import ru.zhendozzz.autoprofi.autoprofi.entity.Student;
import ru.zhendozzz.autoprofi.autoprofi.mapper.StudentMapper;
import ru.zhendozzz.autoprofi.autoprofi.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
@Tag(name = "/api/v1/students", description = "контроллер для обучающихся")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Получение информации по обучающемуся")
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> get(@PathVariable Long id) {
        Student byId = studentService.findById(id);
        return new ResponseEntity<>(StudentMapper.createUserGetResponseDto(byId), HttpStatus.OK);
    }

    @Operation(summary = "Получение информации по обучающемуся")
    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> getAll() {
        List<Student> byAll = studentService.findByAll();
        return new ResponseEntity<>(StudentMapper.createUserListGetResponseDto(byAll), HttpStatus.OK);
    }

    @Operation(summary = "Добавление обучающегося")
    @PostMapping("/")
    public ResponseEntity<Void> put(@RequestBody StudentDto createDto) {
        studentService.create(StudentMapper.createProjectEntity(createDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Обновление обучающегося")
    @PatchMapping("/")
    public ResponseEntity<Void> post(@RequestBody StudentDto updateDto) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Удаление обучающегося")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
