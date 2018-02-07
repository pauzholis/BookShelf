package ru.testproject.bookshelf.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.bookshelf.dao.NotificationDao;
import ru.testproject.bookshelf.dao.UserDao;
import ru.testproject.bookshelf.model.Channel;
import ru.testproject.bookshelf.model.Notification;
import ru.testproject.bookshelf.model.User;
import ru.testproject.bookshelf.model.UserActivation;
import ru.testproject.bookshelf.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final String ACTIVATION_URL = "%shttp://localhost:8080/activation?code=%s";
    private static final String ACTIVATION_MESSAGE = "Для активации вашего аккаунта пройдите по этой ссылке ";
    private final UserDao userDao;
    private final NotificationDao notificationDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, NotificationDao notificationDao) {
        this.userDao = userDao;
        this.notificationDao = notificationDao;
    }

    /**
     * Получить пользователя по id
     */
    @Override
    @Transactional
    public User getUserById(long id) {
        return userDao.findOne(id);
    }

    /**
     * Получить пользователя по электронной почте
     */
    @Override
    @Transactional
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    /**
     * Получить всех пользователей
     */
    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    /**
     * Удалить пользователя
     */
    @Override
    @Transactional
    public void remove(String email) {
        userDao.deleteByEmail(email);
    }

    /**
     * Сохранить нового пользователя
     */
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    /**
     * Генерация кода активации
     */
    private String generateActivationCode() {
        return UUID.randomUUID().toString();
    }

    private UserActivation createUserActivation(User user, String activationCode) {
        return new UserActivation(user, activationCode);
    }

    private void createNotification(User user, String activationCode) {
        Date currentDate = new Date();
        Notification notification = new Notification(Channel.EMAIL, currentDate,
                user.getEmail(), String.format(ACTIVATION_URL, ACTIVATION_MESSAGE, activationCode));
        notificationDao.save(notification);
    }

    @Override
    @Transactional(propagation = REQUIRES_NEW)
    public void registerUser(String email, String password) {
        User user = new User(email, password);
        String activationCode = generateActivationCode();
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        UserActivation userActivation = createUserActivation(user, activationCode);
        user.setUserActivation(userActivation);
        createNotification(user, activationCode);
        save(user);
    }

    @Override
    public void isUserActive(String hash) {
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            if (user.getUserActivation().getHash().equals(hash)) {
                user.setActive(true);
                save(user);
            }
        }
    }
}
