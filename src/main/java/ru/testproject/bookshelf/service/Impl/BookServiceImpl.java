package ru.testproject.bookshelf.service.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.bookshelf.dao.BookDao;
import ru.testproject.bookshelf.dao.ShelfDao;
import ru.testproject.bookshelf.dao.UserDao;
import ru.testproject.bookshelf.model.Book;
import ru.testproject.bookshelf.model.Shelf;
import ru.testproject.bookshelf.service.BookService;
import ru.testproject.bookshelf.view.BookView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class BookServiceImpl implements BookService {
    private static final Logger logger = getLogger(BookServiceImpl.class);
    private final BookDao bookDao;
    private final UserDao userDao;
    private final ShelfDao shelfDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao, UserDao userDao, ShelfDao shelfDao) {
        this.bookDao = bookDao;
        this.userDao = userDao;
        this.shelfDao = shelfDao;
    }

    /**
     * Получить книгу
     */
    @Override
    @Transactional
    public BookView getBook(Long id) {
        Book book = bookDao.findOne(id);
        return new BookView(book.getName(), book.getAuthor(), book.getDescription(), book.getIsbn(), book.getUser(),
                book.getFilePath(),book.getShelf());
    }

    /**
     * Получить все книги
     */
    @Override
    @Transactional
    public List<BookView> getAllBooks() {
        List<Book> books = bookDao.findAll();
        Function<Book, BookView> mapBook = b -> {
            BookView bookView = new BookView();
            bookView.shelf = b.getShelf();
            bookView.user = b.getUser();
            bookView.filePath = b.getFilePath();
            bookView.name = b.getName();
            bookView.author = b.getAuthor();
            bookView.description = b.getDescription();
            bookView.isbn = b.getIsbn();
            return bookView;
        };
        return books.stream().map(mapBook).collect(Collectors.toList());
    }

    /**
     * Добавить новую книгу
     */
    @Override
    @Transactional
    public void update(BookView view) {
        User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = user.getUsername();
                Book book = new Book(view.getName(), view.getAuthor(), view.getDescription(), view.getIsbn(),
                userDao.getUserByEmail(userName), "filePath", view.getShelf());
        bookDao.save(book);
        logger.info("Book add as " + book);
    }

    /**
     * Удалить книгу
     */
    @Override
    public void delete(Long id) {
        bookDao.delete(id);
    }
}
