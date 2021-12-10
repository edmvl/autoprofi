package ru.zhendozzz.autoprofi.autoprofi.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.zhendozzz.autoprofi.autoprofi.dto.ExamBookingDto;
import ru.zhendozzz.autoprofi.autoprofi.entity.ExamBooking;
import ru.zhendozzz.autoprofi.autoprofi.mapper.ExamBookingMapper;
import ru.zhendozzz.autoprofi.autoprofi.repository.projection.ExamBookingInfo;
import ru.zhendozzz.autoprofi.autoprofi.repository.projection.ExamInfo;
import ru.zhendozzz.autoprofi.autoprofi.service.ExamBookingService;

@RestController
@RequestMapping("/api/v1/exambooking")
@Tag(name = "/api/v1/exambooking", description = "контроллер для бронирования")
public class ExamBookingController {
    private final ExamBookingService examBookingService;
    private final ExamBookingMapper examBookingMapper;

    public ExamBookingController(ExamBookingService examBookingService, ExamBookingMapper examBookingMapper) {
        this.examBookingService = examBookingService;
        this.examBookingMapper = examBookingMapper;
    }

    @Operation(summary = "Получение информации по бронированию")
    @GetMapping("/{id}")
    public ResponseEntity<ExamBookingDto> get(@PathVariable Long id) {
        ExamBooking byId = examBookingService.findById(id);
        return new ResponseEntity<>(examBookingMapper.createUserGetResponseDto(byId), HttpStatus.OK);
    }

    @Operation(summary = "Получение информации по всем бронированиям")
    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('exam:read')")
    public ResponseEntity<List<ExamBookingInfo>> getAll(@RequestParam Long studentId) {
        return new ResponseEntity<>(examBookingService.findAll(studentId), HttpStatus.OK);
    }

    @Operation(summary = "Добавление бронирования")
    @PostMapping("/new")
    public ResponseEntity<Void> put(@RequestBody ExamBookingDto createDto) {
        examBookingService.create(examBookingMapper.createProjectEntity(createDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Обновление бронирования")
    @PutMapping("/update")
    public ResponseEntity<Void> post(@RequestBody ExamBookingDto updateDto) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Удаление бронирования")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
