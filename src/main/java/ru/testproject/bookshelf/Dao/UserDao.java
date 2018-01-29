package ru.testproject.bookshelf.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.testproject.bookshelf.model.User;
import java.util.List;

public interface UserDao extends JpaRepository<User,Long> {
    /**
     * Получить пользователя по email
     */
    public User getUserByEmail(String email);
    /**
     * Удалить пользователя по email
     */
public List<User> deleteByEmail(String email);
}
