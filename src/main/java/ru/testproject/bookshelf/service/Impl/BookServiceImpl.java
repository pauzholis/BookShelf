package ru.testproject.bookshelf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.bookshelf.dao.BookDao;
import ru.testproject.bookshelf.model.Book;
import ru.testproject.bookshelf.service.BookService;
import ru.testproject.bookshelf.view.BookView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    /**
     * Получить книгу
     */
    @Override
    @Transactional
    public BookView getBook(Long id) {
        Book book = bookDao.findOne(id);
        return new BookView(book.getShelf(), book.getUser(), book.getFilePath(), book.getName(), book.getAuthor(),
                book.getDescription(), book.getIsbn());
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
        Book book = new Book(view.getShelf(), view.getUser(), view.getFilePath(), view.getName(), view.getAuthor(),
                view.getDescription(), view.getIsbn());
        bookDao.save(book);
    }

    /**
     * Удалить книгу
     */
    @Override
    public void delete(Long id) {
        bookDao.delete(id);
    }
}
