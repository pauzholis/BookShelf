package ru.testproject.bookshelf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class MainPageController {
    @RequestMapping(value = {"/"})
    public String index() {
        return "/showUploadBookPage";
    }
}
