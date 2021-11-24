package ru.zhendozzz.autoprofi.autoprofi.mapper;

import org.springframework.stereotype.Component;
import ru.zhendozzz.autoprofi.autoprofi.dto.InstructorDto;
import ru.zhendozzz.autoprofi.autoprofi.entity.Instructor;

@Component
public class InstructorMapper {
    public InstructorDto createUserGetResponseDto(Instructor byId) {
        return InstructorDto.builder()
            .id(byId.getId())
            .firstName(byId.getFirstName())
            .secondName(byId.getSecondName())
            .middleName(byId.getMiddleName())
            .birthday(byId.getBirthday())
            .build();
    }

    public Instructor createProjectEntity(InstructorDto createDto) {
        return Instructor.builder()
            .birthday(createDto.getBirthday())
            .firstName(createDto.getFirstName())
            .middleName(createDto.getMiddleName())
            .secondName(createDto.getSecondName())
            .build();
    }
}
