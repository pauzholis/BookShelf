package ru.testproject.bookshelf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.testproject.bookshelf.service.UserService;

@Controller
@RequestMapping(value = "/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("user")
    public String getAllUsers(Model model) {
        model.addAttribute("userView", userService.getAllUsers());
        return "user";
    }
}
