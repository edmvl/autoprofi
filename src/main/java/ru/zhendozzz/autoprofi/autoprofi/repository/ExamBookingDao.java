package ru.zhendozzz.autoprofi.autoprofi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.zhendozzz.autoprofi.autoprofi.entity.ExamBooking;
import ru.zhendozzz.autoprofi.autoprofi.repository.projection.ExamBookingInfo;

@Repository
public interface ExamBookingDao extends JpaRepository<ExamBooking, Long> {
    @Query(
        value = "select " +
            " e.id as id," +
            " eb.student_id as studentId," +
            " eb.exam_id as examId," +
            " concat(i.first_name , ' ' , i.second_name) as instructor," +
            " e.date as date," +
            " e.start_time as time" +
            " from exam_booking eb" +
            " LEFT JOIN student s on s.id = eb.student_id" +
            " LEFT JOIN exam e on e.id = eb.exam_id" +
            " LEFT JOIN instructor i on i.id = e.instructor_id" +
            " where student_id=:myid",
        nativeQuery = true
    )
    List<ExamBookingInfo> findMyBookings(Long myid);
}
