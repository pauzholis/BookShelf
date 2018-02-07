package ru.testproject.bookshelf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.testproject.bookshelf.model.Notification;

public interface NotificationDao extends JpaRepository<Notification, Long> {
    /**
     * Получить сообщение по адресу
     */
    Notification findByAdress(String email);
}
