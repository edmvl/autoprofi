package ru.zhendozzz.autoprofi.autoprofi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zhendozzz.autoprofi.autoprofi.entity.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {
    Student findByUserId(Long id);
}
