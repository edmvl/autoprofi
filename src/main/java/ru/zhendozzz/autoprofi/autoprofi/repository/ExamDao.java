package ru.zhendozzz.autoprofi.autoprofi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.zhendozzz.autoprofi.autoprofi.entity.Exam;
import ru.zhendozzz.autoprofi.autoprofi.repository.projection.ExamInfo;

@Repository
public interface ExamDao extends JpaRepository<Exam, Long> {
    @Query(
        value = "select id as id," +
            "       available_slots as availableSlots," +
            "       date as date," +
            "       instructor_id as instructorId," +
            "       start_time as startTime," +
            "       type as type," +
            "       e.available_slots - (select count(0) from exam_booking eb where eb.exam_id=e.id) as count," +
            "       (select count(0)>0 from exam_booking eb where eb.exam_id=e.id and eb.student_id= :myid) as booked" +
            " from exam e",
        nativeQuery = true
    )
    List<ExamInfo> findAllWithBookings(Long myid);
}
