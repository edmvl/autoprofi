package ru.zhendozzz.autoprofi.autoprofi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zhendozzz.autoprofi.autoprofi.entity.User;

@Repository
public interface UserDao  extends JpaRepository<User, Long> {
    User getByLogin(String login);
}
