package ru.testproject.bookshelf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.testproject.bookshelf.model.Notification;
import java.util.List;

public interface NotificationDao extends JpaRepository<Notification, Long> {
    /**
     * Получить сообщениe для активации по адресу
     */
     Notification findByAdress(String email);

}
