package ru.testproject.bookshelf.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.testproject.bookshelf.dao.NotificationDao;
import ru.testproject.bookshelf.service.MailService;

@Service
public class MailServiceImpl implements MailService {
    private static final String EMAIL_SUBJECT = "Активация профиля";
    private final NotificationDao notificationDao;
    private final JavaMailSender sender;

    @Autowired
    public MailServiceImpl(NotificationDao notificationDao, @Qualifier("javaMailSender") JavaMailSender sender) {
        this.notificationDao = notificationDao;
        this.sender = sender;
    }

    @Override
    public void sendEmail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(EMAIL_SUBJECT);
        message.setText(notificationDao.findByAdress(email).getMassage());
        sender.send(message);
    }
}
