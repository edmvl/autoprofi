package ru.zhendozzz.autoprofi.autoprofi.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.zhendozzz.autoprofi.autoprofi.entity.User;
import ru.zhendozzz.autoprofi.autoprofi.repository.UserDao;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byLogin = userDao.getByLogin(username);
        return SecurityUser.fromUser(byLogin);
    }
}
