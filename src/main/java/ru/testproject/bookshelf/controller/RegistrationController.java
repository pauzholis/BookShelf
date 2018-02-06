package ru.testproject.bookshelf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.testproject.bookshelf.model.User;
import ru.testproject.bookshelf.service.MailService;
import ru.testproject.bookshelf.service.UserService;

@Controller
@RequestMapping(value = "/")
public class RegistrationController {

    private final UserService userService;
    private final MailService mailService;

    @Autowired
    public RegistrationController(UserService userService, MailService mailService) {
        this.userService = userService;
        this.mailService = mailService;
    }

    @RequestMapping(value = {"/registration"})
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "/registration";
    }

    @RequestMapping(value = "/registration/submit", method = RequestMethod.POST)
    public String registration(@ModelAttribute User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        User newUser = new User(email, password);
        userService.registerUser(newUser);
        mailService.sendEmail(newUser.getEmail());
        return "/activation";
    }
}
