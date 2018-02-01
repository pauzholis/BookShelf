//package ru.testproject.bookshelf.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import ru.testproject.bookshelf.service.ShelfService;
//
//@Controller
//@RequestMapping(value = "/shelfs")
//public class ShelfController {
//
//    private final ShelfService shelfService;
//
//    @Autowired
//    public ShelfController(ShelfService shelfService) {
//        this.shelfService = shelfService;
//    }
//
//    @RequestMapping(value = "/{id}")
//    public String shelf(@PathVariable("id") Long id) {
//        return "shelf";
//    }
//
//    @RequestMapping(value = "/all")
//    public String getAllShelfs(Model model) {
//        return "shelfs";
//    }
//
//    @RequestMapping(value = "/book")
//    public String getAllBooksFromShelf(Model model) {
//        return "books";
//    }
//
//    @RequestMapping(value = "/delete/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        return "redirect:../";
//    }
//
//    @RequestMapping(value = {"/addShelf"})
//    public String showAddShelfPage(Model model) {
//
//        return "addShelf";
//    }
//
//    @RequestMapping(value = "bank/addBank/submit", method = RequestMethod.POST)
//    public String save() {
//
//        return "redirect:/shelfs";
//    }
//
//}
