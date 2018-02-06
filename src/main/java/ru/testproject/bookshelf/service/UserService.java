package ru.testproject.bookshelf.service;


import ru.testproject.bookshelf.model.User;

import java.util.List;

public interface UserService {
    /**
     * Получение пользователя по идентификатору
     */
    User getUserById(long id);

    /**
     * Получение пользователя по адресу почты
     */
    User getUserByEmail(String email);

    /**
     * Получение списка пользователей
     */
    List<User> getAllUsers();

    /**
     * Сохранение пользователя
     */
    User save(User user);

    /**
     * Удалить пользователей
     */
    List<User> remove(String email);
}
