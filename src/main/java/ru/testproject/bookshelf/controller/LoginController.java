package ru.testproject.bookshelf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.testproject.bookshelf.model.User;
import ru.testproject.bookshelf.service.CaptchaService;
import ru.testproject.bookshelf.service.SecurityService;
import ru.testproject.bookshelf.service.UserService;
import ru.testproject.bookshelf.validator.UserValidator;


@Controller
@RequestMapping(value = "login")
public class LoginController {

    private final UserService userService;
//    private final CaptchaService captchaService;
    private final SecurityService securityService;
    private final UserValidator userValidator;

    @Autowired
    public LoginController(UserService userService, SecurityService securityService,
                           UserValidator userValidator) {
        this.userService = userService;
//        this.captchaService = captchaService;
        this.securityService = securityService;
        this.userValidator = userValidator;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("UserForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getEmail(), userForm.getPassword());

        return "redirect:/index";

    }
}
