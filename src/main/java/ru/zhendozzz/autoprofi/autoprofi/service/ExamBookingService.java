package ru.zhendozzz.autoprofi.autoprofi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import ru.zhendozzz.autoprofi.autoprofi.dto.ExamBookingDto;
import ru.zhendozzz.autoprofi.autoprofi.entity.Exam;
import ru.zhendozzz.autoprofi.autoprofi.entity.ExamBooking;
import ru.zhendozzz.autoprofi.autoprofi.entity.Student;
import ru.zhendozzz.autoprofi.autoprofi.exceptions.EntityNotFoundException;
import ru.zhendozzz.autoprofi.autoprofi.mapper.ExamBookingMapper;
import ru.zhendozzz.autoprofi.autoprofi.repository.ExamBookingDao;
import ru.zhendozzz.autoprofi.autoprofi.repository.ExamDao;
import ru.zhendozzz.autoprofi.autoprofi.repository.StudentDao;

@Service
public class ExamBookingService {

    private final ExamBookingDao examBookingDao;
    private final StudentDao studentDao;
    private final ExamDao examDao;
    private final ExamBookingMapper examBookingMapper;

    public ExamBookingService(ExamBookingDao examBookingDao, StudentDao studentDao, ExamDao examDao, ExamBookingMapper examBookingMapper) {
        this.examBookingDao = examBookingDao;
        this.studentDao = studentDao;
        this.examDao = examDao;
        this.examBookingMapper = examBookingMapper;
    }

    public ExamBookingDto findById(Long id) {
        Optional<ExamBooking> byId = examBookingDao.findById(id);
        if (byId.isPresent()) {
            return examBookingMapper.createUserGetResponseDto(byId.get());
        }
        throw new EntityNotFoundException("ExamBooking is not found by id");
    }

    public void create(ExamBookingDto examBookingDto) {
        Long examId = examBookingDto.getExamId();
        Long studentId = examBookingDto.getStudentId();
        Optional<Student> studentOptional = studentDao.findById(studentId);
        Optional<Exam> examOptional = examDao.findById(examId);
        if (examOptional.isPresent() && studentOptional.isPresent()){
            Exam exam = examOptional.get();
            exam.getEnrollments().add(studentOptional.get());
            examDao.save(exam);
        }
    }

    public List<ExamBookingDto> findAllByStudentId(Long studentId, Long instructorId) {
        List<ExamBooking> all = examBookingDao.findAll();
        return new ArrayList<>();
    }
}
