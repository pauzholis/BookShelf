package ru.testproject.bookshelf.Dao;



import org.springframework.data.repository.CrudRepository;
import ru.testproject.bookshelf.model.Book;
import java.util.List;

public interface BookDao extends CrudRepository<Book,Long> {
    /**
     * Получение кнрг по автору
     */
public List<Book> getAllByAuthor(String author);

    /**
     * Получение книг по названию
     */
public List<Book> getAllByName(String name);
}
