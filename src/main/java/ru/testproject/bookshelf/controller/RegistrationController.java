package ru.testproject.bookshelf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.testproject.bookshelf.model.User;
import ru.testproject.bookshelf.service.UserService;

@Controller
@RequestMapping(value = "/")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/"})
    public String index() {
        return "/index";
    }

    @RequestMapping(value = {"/registration"})
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "/registration";
    }

    @RequestMapping(value = "/registration/submit", method = RequestMethod.POST)
    public String update(@ModelAttribute User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        Boolean active = true;
        User newUser = new User(email, password, active);
        userService.save(newUser);
        return "redirect:/upload";
    }


}
