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
            .examId(byId.getExam().getId())
            .studentId(byId.getStudent().getId())
            .build();
    }

    public ExamBooking createExamBookingEntity(ExamBookingDto createDto) {
        return ExamBooking.builder()
            .id(createDto.getId())
            //.exam(createDto.getExamId())
            //.studentId(createDto.getStudentId())
            .build();
    }
}
