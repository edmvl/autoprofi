package ru.zhendozzz.autoprofi.autoprofi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDto {

    private Long id;

    private String firstName;

    private String secondName;

    private String middleName;

    private String birthday;

}
