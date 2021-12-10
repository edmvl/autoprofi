package ru.zhendozzz.autoprofi.autoprofi.repository.projection;

public interface ExamBookingInfo {
    Long getId();
    Long getExamId();
    Long getStudentId();
    String getDate();
    String getTime();
    String getInstructor();
}
