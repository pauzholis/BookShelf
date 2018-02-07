package ru.testproject.bookshelf.service;


import ru.testproject.bookshelf.model.Notification;

import java.util.List;

public interface NotificationService {

    List<Notification> findAll();
}
