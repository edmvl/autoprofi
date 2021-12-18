package ru.zhendozzz.autoprofi.autoprofi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import ru.zhendozzz.autoprofi.autoprofi.dto.ExamBookingDto;
import ru.zhendozzz.autoprofi.autoprofi.entity.ExamBooking;
import ru.zhendozzz.autoprofi.autoprofi.exceptions.EntityNotFoundException;
import ru.zhendozzz.autoprofi.autoprofi.mapper.ExamBookingMapper;
import ru.zhendozzz.autoprofi.autoprofi.repository.ExamBookingDao;

@Service
public class ExamBookingService {

    private final ExamBookingDao examBookingDao;
    private final ExamBookingMapper examBookingMapper;

    public ExamBookingService(ExamBookingDao examBookingDao, ExamBookingMapper examBookingMapper) {
        this.examBookingDao = examBookingDao;
        this.examBookingMapper = examBookingMapper;
    }

    public ExamBookingDto findById(Long id) {
        Optional<ExamBooking> byId = examBookingDao.findById(id);
        if (byId.isPresent()) {
            return examBookingMapper.createUserGetResponseDto(byId.get());
        }
        throw new EntityNotFoundException("ExamBooking is not found by id");
    }

    public void create(ExamBookingDto examBooking) {
        ExamBooking projectEntity = examBookingMapper.createExamBookingEntity(examBooking);
        examBookingDao.save(projectEntity);
    }

    public List<ExamBookingDto> findAllByStudentId(Long studentId, Long instructorId) {
        List<ExamBooking> all = examBookingDao.findAll();
        return new ArrayList<>();
    }
}
