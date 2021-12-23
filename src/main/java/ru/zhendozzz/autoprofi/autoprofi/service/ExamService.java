package ru.zhendozzz.autoprofi.autoprofi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import ru.zhendozzz.autoprofi.autoprofi.dto.ExamDto;
import ru.zhendozzz.autoprofi.autoprofi.entity.Exam;
import ru.zhendozzz.autoprofi.autoprofi.entity.Instructor;
import ru.zhendozzz.autoprofi.autoprofi.exceptions.EntityNotFoundException;
import ru.zhendozzz.autoprofi.autoprofi.mapper.ExamMapper;
import ru.zhendozzz.autoprofi.autoprofi.repository.ExamDao;
import ru.zhendozzz.autoprofi.autoprofi.repository.InstructorDao;

@Service
public class ExamService {

    private final ExamDao examDao;
    private final InstructorDao instructorDao;

    public ExamService(ExamDao examDao, InstructorDao instructorDao) {
        this.examDao = examDao;
        this.instructorDao = instructorDao;
    }

    public ExamDto findById(Long id) {
        Optional<Exam> byId = examDao.findById(id);
        if (byId.isPresent()) {
            return ExamMapper.createExamGetResponseDto(byId.get());
        }
        throw new EntityNotFoundException("Exam is not found by id");
    }

    public List<ExamDto> findAll(Long myid) {
        List<Exam> all = examDao.findAll();
        return new ArrayList<>();
    }

    public void create(ExamDto examDto) {
        Long instructorId = examDto.getInstructorId();
        Optional<Instructor> byId = instructorDao.findById(instructorId);
        if (byId.isPresent()){
            examDao.save(ExamMapper.createExamEntity(examDto, byId.get()));
        }
    }
}
