package ru.zhendozzz.autoprofi.autoprofi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import ru.zhendozzz.autoprofi.autoprofi.dto.ExamBookingDto;
import ru.zhendozzz.autoprofi.autoprofi.entity.Exam;
import ru.zhendozzz.autoprofi.autoprofi.entity.Student;
import ru.zhendozzz.autoprofi.autoprofi.exceptions.EntityNotFoundException;
import ru.zhendozzz.autoprofi.autoprofi.repository.ExamDao;
import ru.zhendozzz.autoprofi.autoprofi.repository.StudentDao;

@Service
public class ExamBookingService {

    private final StudentDao studentDao;
    private final ExamDao examDao;

    public ExamBookingService( StudentDao studentDao, ExamDao examDao) {
        this.studentDao = studentDao;
        this.examDao = examDao;
    }

    public ExamBookingDto findById(Long id) {

        throw new EntityNotFoundException("ExamBooking is not found by id");
    }

    public void create(ExamBookingDto examBookingDto) {
        Long examId = examBookingDto.getExamId();
        Long studentId = examBookingDto.getStudentId();
        Optional<Student> studentOptional = studentDao.findById(studentId);
        Optional<Exam> examOptional = examDao.findById(examId);
        if (examOptional.isPresent() && studentOptional.isPresent()){
            Exam exam = examOptional.get();
            List<Student> enrollments = exam.getEnrollments();
            enrollments.add(studentOptional.get());
            exam.setEnrollments(enrollments);
            examDao.save(exam);
        }
    }

    public List<ExamBookingDto> findAllByStudentId(Long studentId, Long instructorId) {
        return new ArrayList<>();
    }
}
