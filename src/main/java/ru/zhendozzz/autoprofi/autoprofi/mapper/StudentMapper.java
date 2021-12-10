package ru.zhendozzz.autoprofi.autoprofi.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import ru.zhendozzz.autoprofi.autoprofi.dto.StudentDto;
import ru.zhendozzz.autoprofi.autoprofi.entity.Student;

@Component
public class StudentMapper {
    public static StudentDto createUserGetResponseDto(Student byId) {
        return StudentDto.builder()
            .id(byId.getId())
            .firstName(byId.getFirstName())
            .secondName(byId.getSecondName())
            .middleName(byId.getMiddleName())
            .birthday(byId.getBirthday())
            .build();
    }

    public static List<StudentDto> createUserListGetResponseDto(List<Student> byAll) {
        return byAll.stream()
            .map(StudentMapper::createUserGetResponseDto)
            .collect(Collectors.toList());

    }


    public static Student createProjectEntity(StudentDto createDto) {
        return Student.builder()
            .birthday(createDto.getBirthday())
            .firstName(createDto.getFirstName())
            .middleName(createDto.getMiddleName())
            .secondName(createDto.getSecondName())
            .build();
    }
}
