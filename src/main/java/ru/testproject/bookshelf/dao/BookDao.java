package ru.testproject.bookshelf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.testproject.bookshelf.model.Book;
import ru.testproject.bookshelf.model.User;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Long> {
    /**
     * Получение книг по автору
     */
    List<Book> getAllByAuthor(String author, User user);

    /**
     * Получение книг по названию
     */
    List<Book> getAllByName(String name, User user);

    Book findByFilePath (String filePath);
}
