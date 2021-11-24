package ru.zhendozzz.autoprofi.autoprofi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import ru.zhendozzz.autoprofi.autoprofi.entity.Student;
import ru.zhendozzz.autoprofi.autoprofi.exceptions.EntityNotFoundException;
import ru.zhendozzz.autoprofi.autoprofi.repository.StudentDao;

@Service
public class StudentService {
    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void create(Student student) {
        studentDao.save(student);
    }

    public Student findById(Long id) {
        Optional<Student> byId = studentDao.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        throw new EntityNotFoundException("Student is not found by id");
    }

    public void delete(Long id) {
        Optional<Student> byId = studentDao.findById(id);
        if (byId.isPresent()) {
            studentDao.delete(byId.get());
        } else {
            throw new EntityNotFoundException("Project is not found by id");
        }
    }
}
