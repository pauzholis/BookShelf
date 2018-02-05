package ru.testproject.bookshelf.service;


import ru.testproject.bookshelf.view.BookView;

import java.util.List;

public interface BookService {
    BookView getBook (Long id);
    List<BookView> getAllBooks();
    void update (BookView view);
    void delete (Long id);
}
