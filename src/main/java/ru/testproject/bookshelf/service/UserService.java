package ru.testproject.bookshelf.service;


import ru.testproject.bookshelf.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
