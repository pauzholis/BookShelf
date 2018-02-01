package ru.testproject.bookshelf.dao;

import org.springframework.data.repository.CrudRepository;
import ru.testproject.bookshelf.model.Notification;

import java.util.List;

public interface NotificationDao extends CrudRepository<Notification, Long> {
    /**
     * Получить список сообщений для активации по адресу
     */
    List<Notification> findByAdress(String adress);
}
