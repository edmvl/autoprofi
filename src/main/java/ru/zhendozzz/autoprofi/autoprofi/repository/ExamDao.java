package ru.zhendozzz.autoprofi.autoprofi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zhendozzz.autoprofi.autoprofi.entity.Exam;

@Repository
public interface ExamDao extends JpaRepository<Exam, Long> {
}
