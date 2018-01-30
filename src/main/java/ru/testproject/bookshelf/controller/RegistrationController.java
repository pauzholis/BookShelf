package ru.testproject.bookshelf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.testproject.bookshelf.service.CaptchaService;
import ru.testproject.bookshelf.service.UserService;

@Controller
@RequestMapping(value = "registration")
public class RegistrationController {
    private final JavaMailSender javaMailSender;
    private final UserService userService;
    private final CaptchaService captchaService;

    @Autowired
    public RegistrationController(JavaMailSender javaMailSender, UserService userService, CaptchaService captchaService) {
        this.javaMailSender = javaMailSender;
        this.userService = userService;
        this.captchaService = captchaService;
    }
    @RequestMapping(value = { "/addUser" })
    public String showAddShelfPage(Model model) {
        return "addUser";
    }
    @RequestMapping(value = "addUser/submit", method = RequestMethod.POST)
    public String update (){
        return "redirect:/shelfs";
    }


}
