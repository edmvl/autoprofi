package ru.zhendozzz.autoprofi.autoprofi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zhendozzz.autoprofi.autoprofi.dto.ExamDto;
import ru.zhendozzz.autoprofi.autoprofi.entity.Exam;
import ru.zhendozzz.autoprofi.autoprofi.mapper.ExamMapper;
import ru.zhendozzz.autoprofi.autoprofi.service.ExamService;


@RestController
@RequestMapping("/exam")
@Tag(name = "/exam", description = "контроллер для инструкторов")
public class ExamController {
    private final ExamService examService;
    private final ExamMapper examMapper;

    public ExamController(ExamService examService, ExamMapper examMapper) {
        this.examService = examService;
        this.examMapper = examMapper;
    }

    @Operation(summary = "Получение информации по инструктору")
    @GetMapping("/{id}")
    public ResponseEntity<ExamDto> get(@PathVariable Long id) {
        Exam byId = examService.findById(id);
        return new ResponseEntity<>(examMapper.createUserGetResponseDto(byId), HttpStatus.OK);
    }

    @Operation(summary = "Добавление инструктора")
    @PostMapping("/new")
    public ResponseEntity<Void> put(@RequestBody ExamDto createDto) {
        examService.create(examMapper.createProjectEntity(createDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Обновление инструктора")
    @PutMapping("/update")
    public ResponseEntity<Void> post(@RequestBody ExamDto updateDto) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Удаление инструктора")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
