package ru.testproject.bookshelf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.bookshelf.dao.NotificationDao;
import ru.testproject.bookshelf.model.Notification;
import ru.testproject.bookshelf.service.NotificationService;

import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class NotificationServiceImpl implements NotificationService {
    private final NotificationDao notificationDao;

    @Autowired
    public NotificationServiceImpl(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    @Override
    @Transactional
    public List<Notification> findAll() {
        return notificationDao.findAll();
    }
}
