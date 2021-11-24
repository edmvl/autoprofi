package ru.zhendozzz.autoprofi.autoprofi.mapper;

import org.springframework.stereotype.Component;
import ru.zhendozzz.autoprofi.autoprofi.dto.ExamDto;
import ru.zhendozzz.autoprofi.autoprofi.entity.Exam;

@Component
public class ExamMapper {
    public ExamDto createUserGetResponseDto(Exam byId) {
        return ExamDto.builder()
            .id(byId.getId())
            .type(byId.getType())
            .date(byId.getDate())
            .startTime(byId.getStartTime())
            .availableSlots(byId.getAvailableSlots())
            .instructorId(byId.getInstructorId())
            .build();
    }

    public Exam createProjectEntity(ExamDto createDto) {
        return Exam.builder()
            .id(createDto.getId())
            .type(createDto.getType())
            .date(createDto.getDate())
            .startTime(createDto.getStartTime())
            .availableSlots(createDto.getAvailableSlots())
            .instructorId(createDto.getInstructorId())
            .build();
    }
}
