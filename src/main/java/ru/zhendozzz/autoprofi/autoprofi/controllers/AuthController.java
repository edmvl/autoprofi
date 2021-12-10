package ru.zhendozzz.autoprofi.autoprofi.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zhendozzz.autoprofi.autoprofi.dto.AuthRequestDto;
import ru.zhendozzz.autoprofi.autoprofi.entity.Instructor;
import ru.zhendozzz.autoprofi.autoprofi.entity.Student;
import ru.zhendozzz.autoprofi.autoprofi.entity.User;
import ru.zhendozzz.autoprofi.autoprofi.repository.InstructorDao;
import ru.zhendozzz.autoprofi.autoprofi.repository.StudentDao;
import ru.zhendozzz.autoprofi.autoprofi.repository.UserDao;
import ru.zhendozzz.autoprofi.autoprofi.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final StudentDao studentDao;
    private final InstructorDao instructorDao;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(AuthenticationManager authenticationManager, UserDao userDao, StudentDao studentDao, InstructorDao instructorDao, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userDao = userDao;
        this.studentDao = studentDao;
        this.instructorDao = instructorDao;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDto req) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getLogin(), req.getPassword()));
        User user = userDao.getByLogin(req.getLogin());
        Student student = studentDao.findByUserId(user.getId());
        Instructor instructor = instructorDao.findByUserId(user.getId());
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("User doesn't exists");
        }
        String token = jwtTokenProvider.createToken(req.getLogin(), user.getRole().name());
        Map<Object, Object> response = new HashMap<>();
        response.put("login", req.getLogin());
        response.put("token", token);
        response.put("userId", user.getId());
        response.put("studentId", Objects.isNull(student) ? null : student.getId());
        response.put("instructorId", Objects.isNull(instructor) ? null : instructor.getId());
        response.put("userRole", user.getRole());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest req, HttpServletResponse res) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(req, res, null);
    }
}
