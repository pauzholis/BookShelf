package ru.testproject.bookshelf.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.testproject.bookshelf.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    User getUserById(long id);

    User getUserByEmail(String email);

    List<User> getAllUsers();

    User save(User user);

    List<User> remove(String email);
}
