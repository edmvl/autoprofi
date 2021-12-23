package ru.zhendozzz.autoprofi.autoprofi.controllers;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.zhendozzz.autoprofi.autoprofi.dto.ExamDto;
import ru.zhendozzz.autoprofi.autoprofi.service.ExamService;


@RestController
@RequestMapping("/api/v1/exams")
@Tag(name = "/api/v1/exams", description = "контроллер для экзамену")
public class ExamController {
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @Operation(summary = "Получение информации по экзамену")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('exam:read')")
    public ResponseEntity<ExamDto> get(@PathVariable Long id) {
        return new ResponseEntity<>(examService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Получение информации по всем экзаменам")
    @GetMapping("/")
    @PreAuthorize("hasAnyAuthority('exam:read')")
    public ResponseEntity<List<ExamDto>> getAll(@RequestParam Long studentId) {
        return new ResponseEntity<>(examService.findAll(studentId), HttpStatus.OK);
    }

    @Operation(summary = "Добавление экзамена")
    @PostMapping("/")
    @PreAuthorize("hasAnyAuthority('exam:create')")
    public ResponseEntity<Void> add(@RequestBody ExamDto createDto) {
        examService.create(createDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Обновление экзамена")
    @PatchMapping("/")
    @PreAuthorize("hasAnyAuthority('exam:write')")
    public ResponseEntity<Void> update(@RequestBody ExamDto updateDto) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Удаление экзамена")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('exam:write')")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
