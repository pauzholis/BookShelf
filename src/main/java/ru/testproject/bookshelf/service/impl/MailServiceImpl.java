package ru.testproject.bookshelf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.bookshelf.dao.NotificationDao;
import ru.testproject.bookshelf.model.Notification;
import ru.testproject.bookshelf.service.MailService;

import java.util.List;

@Service
public class MailServiceImpl implements MailService {

    private final NotificationDao notificationDao;
    private final JavaMailSender sender;

    @Autowired
    public MailServiceImpl(NotificationDao notificationDao, @Qualifier("javaMailSender") JavaMailSender sender) {
        this.notificationDao = notificationDao;
        this.sender = sender;
    }

    @Override
    @Transactional
    @Scheduled(fixedRate = 5000)
    public void sendNextMail() {
        List<Notification> notificationList = notificationDao.findAll();
        SimpleMailMessage message = new SimpleMailMessage();
        for (Notification n : notificationList) {
            if (n != null) {
                message.setTo(n.getAdress());
                message.setText(n.getMassage());
                sender.send(message);
                notificationDao.delete(n.getId());
            }
        }
    }
}