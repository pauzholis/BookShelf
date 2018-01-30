package ru.testproject.bookshelf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.testproject.bookshelf.service.CaptchaService;
import ru.testproject.bookshelf.service.UserService;

/**
 * Created by Mihail on 30.01.2018.
 */
@Controller
@RequestMapping(value = "login")
public class LoginCotroller {
    private final UserService userService;
    private final CaptchaService captchaService;

    @Autowired
    public LoginCotroller(UserService userService, CaptchaService captchaService) {
        this.userService = userService;
        this.captchaService = captchaService;
    }
//    что тут будет я пока не знаю
}
