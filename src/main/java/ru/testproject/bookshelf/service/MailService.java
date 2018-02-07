package ru.testproject.bookshelf.service;


import ru.testproject.bookshelf.model.Notification;

public interface MailService {

    void sendNextMail(String email);
}
