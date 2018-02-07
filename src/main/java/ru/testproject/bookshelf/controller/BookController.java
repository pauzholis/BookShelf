package ru.testproject.bookshelf.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.testproject.bookshelf.model.Shelf;
import ru.testproject.bookshelf.model.User;
import ru.testproject.bookshelf.service.BookService;
import ru.testproject.bookshelf.view.BookView;

import static org.slf4j.LoggerFactory.getLogger;


@Controller
@RequestMapping(value = "/")
public class BookController {
    private final BookService bookService;

    private static String UPLOADED_FOLDER = "C://temp//";

    private static final Logger logger = getLogger(BookController.class);

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("book")
    public String getAllBooks(Model model) {
        model.addAttribute("bookView", bookService.getAllBooks());
        return "book";
    }

    /**
     * Страница добавления книги
     */
    @RequestMapping(value = {"book/addBook"})
    public String showAddBookPage(Model model) {
        model.addAttribute("bookView", new BookView());
        return "addBook";
    }

    /**
     * Добавление новой книги
     */
    @RequestMapping(value = "book/addBook/submit", method = RequestMethod.POST)
    public String update(@ModelAttribute BookView bookView) {
        Shelf shelf = bookView.getShelf();
        User user = bookView.getUser();
        String filePath = bookView.getFilePath();
        String name = bookView.getName();
        String author = bookView.getAuthor();
        String description = bookView.getDescription();
        Long isbn = bookView.getIsbn();
        BookView newBook = new BookView(shelf, user, filePath, name, author, description, isbn);
        bookService.update(newBook);
        return "redirect:/book";
    }
}
