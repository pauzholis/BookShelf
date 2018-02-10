package ru.testproject.bookshelf.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.testproject.bookshelf.dao.BookDao;
import ru.testproject.bookshelf.dao.ShelfDao;
import ru.testproject.bookshelf.model.Book;
import ru.testproject.bookshelf.model.Shelf;
import ru.testproject.bookshelf.model.User;
import ru.testproject.bookshelf.service.BookService;
import ru.testproject.bookshelf.service.BookUploadService;
import ru.testproject.bookshelf.service.FileUploadService;
import ru.testproject.bookshelf.service.ShelfService;
import ru.testproject.bookshelf.view.BookView;
import ru.testproject.bookshelf.view.ShelfView;

import java.io.IOException;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;


@Controller
@RequestMapping(value = "/")
public class BookController {
    private static Logger logger = getLogger(BookController.class);

    private final BookService bookService;
    private final ShelfService shelfService;
    private final FileUploadService fileUploadService;
    private final BookUploadService bookUploadService;

    @Autowired
    public BookController(BookService bookService, ShelfService shelfService, FileUploadService fileUploadService,
                          BookUploadService bookUploadService) {
        this.bookService = bookService;
        this.shelfService = shelfService;
        this.fileUploadService = fileUploadService;
        this.bookUploadService = bookUploadService;
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
    public String showAddBookPage(Model modelBook) {
        modelBook.addAttribute("bookView", new BookView());
        return "addBook";
    }

    /**
     * Добавление новой книги
     */
    @RequestMapping(value = "book/addBook/submit", method = RequestMethod.POST)
    public String update(@ModelAttribute BookView bookView, @RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String filePath = "";

        if (file.isEmpty()) {
            return "redirect:loadBook";
        }
        try {
            filePath = fileUploadService.uploadFile(file.getBytes(), file.getOriginalFilename());
        } catch (IOException e) {
            logger.error("An error occurred", e);
        }
        Shelf shelf = shelfService.getShelfByName(bookView.getShelfName());
        String name = bookView.getName();
        String author = bookView.getAuthor();
        String description = bookView.getDescription();
        Long isbn = bookView.getIsbn();
        BookView newBook = new BookView(name, author, description, isbn, filePath, shelf);
        bookService.update(newBook);
        bookUploadService.createBookPage(filePath);

        return "redirect:/book";
    }
}
