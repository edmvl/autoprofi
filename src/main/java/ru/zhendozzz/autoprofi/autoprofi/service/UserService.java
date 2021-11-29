package ru.zhendozzz.autoprofi.autoprofi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import ru.zhendozzz.autoprofi.autoprofi.entity.User;
import ru.zhendozzz.autoprofi.autoprofi.exceptions.EntityNotFoundException;
import ru.zhendozzz.autoprofi.autoprofi.repository.UserDao;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao studentDao) {
        this.userDao = studentDao;
    }

    public void create(User user) {
        userDao.save(user);
    }

    public User findById(Long id) {
        Optional<User> byId = userDao.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        throw new EntityNotFoundException("Student is not found by id");
    }

    public void delete(Long id) {
        Optional<User> byId = userDao.findById(id);
        if (byId.isPresent()) {
            userDao.delete(byId.get());
        } else {
            throw new EntityNotFoundException("Project is not found by id");
        }
    }
}
