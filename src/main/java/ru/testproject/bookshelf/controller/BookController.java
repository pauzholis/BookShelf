package ru.testproject.bookshelf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.testproject.bookshelf.service.BookService;


//@Controller
//@RequestMapping(value = "books")
//public class BookController {
//    private final BookService bookService;
//
//    @Autowired
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }
//
//    @RequestMapping(value = "/{id}")
//    public String book(@PathVariable("id") Long id) {
//        return "book";
//    }
//
//    @RequestMapping(value = "/all")
//    public String getAllBooks(Model model) {
//        return "books";
//    }
//
//    @RequestMapping(value = "/delete/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        return "redirect:../";
//    }
//
//    @RequestMapping(value = {"/addBook"})
//    public String showAddShelfPage(Model model) {
//        return "addBook";
//    }
//
//    @RequestMapping(value = "/addBook/submit", method = RequestMethod.POST)
//    public String save() {
//        return "redirect:/books";
//    }
//}
