package ru.zhendozzz.autoprofi.autoprofi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
    //http://localhost/swagger-ui.html
    @RequestMapping("/**/{path:[^.]*}")
    public ModelAndView redirect() {
        return new ModelAndView("forward:/");
    }

}
