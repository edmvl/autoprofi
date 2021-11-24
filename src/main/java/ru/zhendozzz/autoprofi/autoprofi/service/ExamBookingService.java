package ru.zhendozzz.autoprofi.autoprofi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import ru.zhendozzz.autoprofi.autoprofi.entity.Exam;
import ru.zhendozzz.autoprofi.autoprofi.entity.ExamBooking;
import ru.zhendozzz.autoprofi.autoprofi.exceptions.EntityNotFoundException;
import ru.zhendozzz.autoprofi.autoprofi.repository.ExamBookingDao;
import ru.zhendozzz.autoprofi.autoprofi.repository.ExamDao;

@Service
public class ExamBookingService {

    private final ExamBookingDao examBookingDao;

    public ExamBookingService(ExamBookingDao examBookingDao) {
        this.examBookingDao = examBookingDao;
    }

    public ExamBooking findById(Long id) {
        Optional<ExamBooking> byId = examBookingDao.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        throw new EntityNotFoundException("ExamBooking is not found by id");
    }

    public void create(ExamBooking examBooking) {
        examBookingDao.save(examBooking);
    }
}
