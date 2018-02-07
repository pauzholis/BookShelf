package ru.testproject.bookshelf.service;


import ru.testproject.bookshelf.view.BookView;

import java.util.List;

public interface BookService {

    /**
     * Получить книгу
     */
    BookView getBook(Long id);

    /**
     * Получить все книги
     */
    List<BookView> getAllBooks();

    /**
     * Добавить книгу
     */
    void update(BookView view);

    /**
     * Удалить книгу
     */
    void delete(Long id);
}
