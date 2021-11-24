package ru.zhendozzz.autoprofi.autoprofi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zhendozzz.autoprofi.autoprofi.entity.Instructor;

@Repository
public interface InstructorDao extends JpaRepository<Instructor, Long> {
}
