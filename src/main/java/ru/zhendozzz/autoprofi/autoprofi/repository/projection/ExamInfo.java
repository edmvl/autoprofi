package ru.zhendozzz.autoprofi.autoprofi.repository.projection;


public interface ExamInfo {
     Long getId();
     String getType();
     String getDate();
     String getStartTime();
     Integer getAvailableSlots();
     Long getInstructorId();
     Integer getCount();
     Boolean getBooked();
}
