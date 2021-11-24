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
import ru.zhendozzz.autoprofi.autoprofi.dto.ExamBookingDto;
import ru.zhendozzz.autoprofi.autoprofi.entity.ExamBooking;
import ru.zhendozzz.autoprofi.autoprofi.mapper.ExamBookingMapper;
import ru.zhendozzz.autoprofi.autoprofi.service.ExamBookingService;

@RestController
@RequestMapping("/exambooking")
@Tag(name = "/exambooking", description = "контроллер для инструкторов")
public class ExamBookingController {
    private final ExamBookingService ExamBookingService;
    private final ExamBookingMapper ExamBookingMapper;

    public ExamBookingController(ExamBookingService ExamBookingService, ExamBookingMapper ExamBookingMapper) {
        this.ExamBookingService = ExamBookingService;
        this.ExamBookingMapper = ExamBookingMapper;
    }

    @Operation(summary = "Получение информации по инструктору")
    @GetMapping("/{id}")
    public ResponseEntity<ExamBookingDto> get(@PathVariable Long id) {
        ExamBooking byId = ExamBookingService.findById(id);
        return new ResponseEntity<>(ExamBookingMapper.createUserGetResponseDto(byId), HttpStatus.OK);
    }

    @Operation(summary = "Добавление инструктора")
    @PostMapping("/new")
    public ResponseEntity<Void> put(@RequestBody ExamBookingDto createDto) {
        ExamBookingService.create(ExamBookingMapper.createProjectEntity(createDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Обновление инструктора")
    @PutMapping("/update")
    public ResponseEntity<Void> post(@RequestBody ExamBookingDto updateDto) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Удаление инструктора")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
