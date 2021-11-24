package ru.zhendozzz.autoprofi.autoprofi.mapper;

import org.springframework.stereotype.Component;
import ru.zhendozzz.autoprofi.autoprofi.dto.StudentDto;
import ru.zhendozzz.autoprofi.autoprofi.entity.Student;

@Component
public class StudentMapper {
    public StudentDto createUserGetResponseDto(Student byId) {
        return StudentDto.builder()
            .id(byId.getId())
            .firstName(byId.getFirstName())
            .secondName(byId.getSecondName())
            .middleName(byId.getMiddleName())
            .birthday(byId.getBirthday())
            .build();
    }

    public Student createProjectEntity(StudentDto createDto) {
        return Student.builder()
            .birthday(createDto.getBirthday())
            .firstName(createDto.getFirstName())
            .middleName(createDto.getMiddleName())
            .secondName(createDto.getSecondName())
            .build();
    }
}
