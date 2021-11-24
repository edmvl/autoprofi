package ru.zhendozzz.autoprofi.autoprofi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import ru.zhendozzz.autoprofi.autoprofi.entity.Exam;
import ru.zhendozzz.autoprofi.autoprofi.entity.Instructor;
import ru.zhendozzz.autoprofi.autoprofi.exceptions.EntityNotFoundException;
import ru.zhendozzz.autoprofi.autoprofi.repository.ExamDao;
import ru.zhendozzz.autoprofi.autoprofi.repository.InstructorDao;

@Service
public class ExamService {

    private final ExamDao examDao;

    public ExamService(ExamDao examDao) {
        this.examDao = examDao;
    }

    public Exam findById(Long id) {
        Optional<Exam> byId = examDao.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        throw new EntityNotFoundException("Exam is not found by id");
    }

    public void create(Exam exam) {
        examDao.save(exam);
    }
}
