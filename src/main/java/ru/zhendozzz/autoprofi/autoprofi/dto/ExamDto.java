package ru.zhendozzz.autoprofi.autoprofi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamDto {

    private Long id;

    private String type;

    private String date;

    private String startTime;

    private Integer availableSlots;

    private Long instructorId;

}
