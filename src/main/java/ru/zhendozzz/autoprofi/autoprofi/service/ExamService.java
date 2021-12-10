package ru.zhendozzz.autoprofi.autoprofi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import ru.zhendozzz.autoprofi.autoprofi.dto.ExamDto;
import ru.zhendozzz.autoprofi.autoprofi.entity.Exam;
import ru.zhendozzz.autoprofi.autoprofi.exceptions.EntityNotFoundException;
import ru.zhendozzz.autoprofi.autoprofi.mapper.ExamMapper;
import ru.zhendozzz.autoprofi.autoprofi.repository.ExamDao;
import ru.zhendozzz.autoprofi.autoprofi.repository.projection.ExamInfo;

@Service
public class ExamService {

    private final ExamDao examDao;

    public ExamService(ExamDao examDao) {
        this.examDao = examDao;
    }

    public ExamDto findById(Long id) {
        Optional<Exam> byId = examDao.findById(id);
        if (byId.isPresent()) {
            return ExamMapper.createExamGetResponseDto(byId.get());
        }
        throw new EntityNotFoundException("Exam is not found by id");
    }

    public List<ExamInfo> findAll(Long myid) {
        return examDao.findAllWithBookings(myid);
    }

    public void create(ExamDto exam) {
        examDao.save(ExamMapper.createExamEntity(exam));
    }
}
