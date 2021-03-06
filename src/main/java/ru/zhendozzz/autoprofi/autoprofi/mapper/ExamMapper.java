package ru.zhendozzz.autoprofi.autoprofi.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import ru.zhendozzz.autoprofi.autoprofi.dto.ExamDto;
import ru.zhendozzz.autoprofi.autoprofi.entity.Exam;
import ru.zhendozzz.autoprofi.autoprofi.repository.projection.ExamInfo;

@Component
public class ExamMapper {
    public static ExamDto createExamGetResponseDto(Exam byId) {
        return ExamDto.builder()
            .id(byId.getId())
            .type(byId.getType())
            .date(byId.getDate())
            .startTime(byId.getStartTime())
            .availableSlots(byId.getAvailableSlots())
            .instructorId(byId.getInstructorId())
            .build();
    }

    public static Exam createExamEntity(ExamDto createDto) {
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
