package ru.testproject.bookshelf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.testproject.bookshelf.model.User;
import java.util.List;


public interface UserDao extends JpaRepository<User, Long> {
    /**
     * Получить пользователя по email
     */
    User getUserByEmail(String email);

    /**
     * Удалить пользователя по email
     */
    List<User> deleteByEmail(String email);
}
