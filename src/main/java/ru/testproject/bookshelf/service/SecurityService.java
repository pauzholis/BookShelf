package ru.testproject.bookshelf.service;


public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String email, String password);
}
