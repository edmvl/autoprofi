package ru.zhendozzz.autoprofi.autoprofi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api/v1/exam")
@Tag(name = "/api/v1/exam", description = "контроллер для экзамену")
public class ExamController {
    private final ExamService examService;
    private final ExamMapper examMapper;

    public ExamController(ExamService examService, ExamMapper examMapper) {
        this.examService = examService;
        this.examMapper = examMapper;
    }

    @Operation(summary = "Получение информации по экзамену")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('exam:read')")
    public ResponseEntity<ExamDto> get(@PathVariable Long id) {
        Exam byId = examService.findById(id);
        return new ResponseEntity<>(examMapper.createUserGetResponseDto(byId), HttpStatus.OK);
    }

    @Operation(summary = "Добавление экзамена")
    @PostMapping("/new")
    @PreAuthorize("hasAnyAuthority('exam:write')")
    public ResponseEntity<Void> put(@RequestBody ExamDto createDto) {
        examService.create(examMapper.createProjectEntity(createDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Обновление экзамена")
    @PutMapping("/update")
    @PreAuthorize("hasAnyAuthority('exam:write')")
    public ResponseEntity<Void> post(@RequestBody ExamDto updateDto) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Удаление экзамена")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('exam:write')")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
