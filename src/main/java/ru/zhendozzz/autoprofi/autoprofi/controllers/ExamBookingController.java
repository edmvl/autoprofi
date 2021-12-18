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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.zhendozzz.autoprofi.autoprofi.dto.ExamBookingDto;
import ru.zhendozzz.autoprofi.autoprofi.mapper.ExamBookingMapper;
import ru.zhendozzz.autoprofi.autoprofi.service.ExamBookingService;

@RestController
@RequestMapping("/api/v1/exambookings")
@Tag(name = "/api/v1/exambookings", description = "контроллер для бронирования")
public class ExamBookingController {
    private final ExamBookingService examBookingService;

    public ExamBookingController(ExamBookingService examBookingService, ExamBookingMapper examBookingMapper) {
        this.examBookingService = examBookingService;
    }

    @Operation(summary = "Получение информации по бронированию")
    @GetMapping("/{id}")
    public ResponseEntity<ExamBookingDto> get(@PathVariable Long id) {
        return new ResponseEntity<>(examBookingService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Получение информации по всем бронированиям")
    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('exam:read')")
    public ResponseEntity<List<ExamBookingDto>> getAll(
        @RequestParam(required = false) Long studentId,
        @RequestParam(required = false) Long instructorId
    ) {
        return new ResponseEntity<>(examBookingService.findAllByStudentId(studentId, instructorId), HttpStatus.OK);
    }

    @Operation(summary = "Добавление бронирования")
    @PostMapping("/")
    public ResponseEntity<Void> put(@RequestBody ExamBookingDto createDto) {
        examBookingService.create(createDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Обновление бронирования")
    @PatchMapping("/")
    public ResponseEntity<Void> post(@RequestBody ExamBookingDto updateDto) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Удаление бронирования")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
