package ru.zhendozzz.autoprofi.autoprofi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import ru.zhendozzz.autoprofi.autoprofi.entity.Instructor;
import ru.zhendozzz.autoprofi.autoprofi.exceptions.EntityNotFoundException;
import ru.zhendozzz.autoprofi.autoprofi.repository.InstructorDao;

@Service
public class InstructorService {

    private final InstructorDao instructorDao;

    public InstructorService(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }

    public Instructor findById(Long id) {
        Optional<Instructor> byId = instructorDao.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        throw new EntityNotFoundException("Instructor is not found by id");
    }

    public void create(Instructor instructor) {
        instructorDao.save(instructor);
    }
}
