package ru.testproject.bookshelf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.testproject.bookshelf.service.UserService;

@Controller
public class ActivationController {
    private final UserService userService;

    @Autowired
    public ActivationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/activation/{hash}", method = RequestMethod.GET)
    public String checkHashValid(@PathVariable("hash") String hash) {
        userService.selectUserActive(hash);
        return "/user";
    }
}

