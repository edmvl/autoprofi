package ru.zhendozzz.autoprofi.autoprofi.mapper;

import org.springframework.stereotype.Component;
import ru.zhendozzz.autoprofi.autoprofi.dto.ExamBookingDto;
import ru.zhendozzz.autoprofi.autoprofi.dto.InstructorDto;
import ru.zhendozzz.autoprofi.autoprofi.entity.ExamBooking;
import ru.zhendozzz.autoprofi.autoprofi.entity.Instructor;

@Component
public class ExamBookingMapper {
    public ExamBookingDto createUserGetResponseDto(ExamBooking byId) {
        return ExamBookingDto.builder()
            .id(byId.getId())
            .examId(byId.getExamId())
            .studentId(byId.getStudentId())
            .build();
    }

    public ExamBooking createProjectEntity(ExamBookingDto createDto) {
        return ExamBooking.builder()
            .id(createDto.getId())
            .examId(createDto.getExamId())
            .studentId(createDto.getStudentId())
            .build();
    }
}
