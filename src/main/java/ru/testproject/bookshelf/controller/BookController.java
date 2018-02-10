package ru.testproject.bookshelf.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.testproject.bookshelf.dao.BookDao;
import ru.testproject.bookshelf.dao.ShelfDao;
import ru.testproject.bookshelf.model.Book;
import ru.testproject.bookshelf.model.Shelf;
import ru.testproject.bookshelf.model.User;
import ru.testproject.bookshelf.service.BookService;
import ru.testproject.bookshelf.service.ShelfService;
import ru.testproject.bookshelf.view.BookView;
import ru.testproject.bookshelf.view.ShelfView;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;


@Controller
@RequestMapping(value = "/")
public class BookController {
    private static Logger logger = getLogger(BookController.class);

    private final BookService bookService;
    private final ShelfService shelfService;

    @Autowired
    public BookController(BookService bookService, ShelfService shelfService) {
        this.bookService = bookService;
        this.shelfService = shelfService;
    }


    @RequestMapping("book")
    public String getAllBooks(Model model) {
        model.addAttribute("bookView", bookService.getAllBooks());
        return "book";
    }

    /**
     * Страница добавления книги
     */
    @RequestMapping(value = {"book/addBook"}, method = RequestMethod.GET)
    public String showAddBookPage(Model modelBook, Model modelShelf) {
        modelBook.addAttribute("bookView", new BookView());

        List<ShelfView> shelves = shelfService.getAllShelves();
        modelShelf.addAttribute("shelves", shelves);

        return "addBook";
    }

    /**
     * Добавление новой книги
     */
    @RequestMapping(value = "book/addBook/submit", method = RequestMethod.POST)
    public String update(@ModelAttribute BookView bookView) {

        Shelf shelf = shelfService.getShelfByName(bookView.getShelfName());
        String filePath = bookView.getFilePath();
        String name = bookView.getName();
        String author = bookView.getAuthor();
        String description = bookView.getDescription();
        Long isbn = bookView.getIsbn();
        BookView newBook = new BookView(name, author, description, isbn, filePath, shelf);
        bookService.update(newBook);
        return "redirect:/book";
    }
}
