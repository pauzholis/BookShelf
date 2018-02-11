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
     * Удалить пользователей
     */
    void remove(String email);

    /**
     * Регистрация пользователя
     */
    void registerUser(String email, String password);

    /**
     * Сохранение пользователя
     */
    void save(User user);

    /**
     * Установка активации пользователя
     */
    void selectUserActive(String email);
}
