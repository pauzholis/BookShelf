package ru.testproject.bookshelf.service.Impl;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.bookshelf.dao.NotificationDao;
import ru.testproject.bookshelf.dao.UserDao;
import ru.testproject.bookshelf.model.Channel;
import ru.testproject.bookshelf.model.Notification;
import ru.testproject.bookshelf.model.User;
import ru.testproject.bookshelf.model.UserActivation;
import ru.testproject.bookshelf.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Repository
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final String ACTIVATION_URL = "http://localhost:8080/activation?code=%s";
    private final UserDao userDao;
    private final NotificationDao notificationDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder, NotificationDao notificationDao) {
        this.userDao = userDao;
        this.notificationDao = notificationDao;
    }


    @Override
    @Transactional
    public User getUserById(long id) {
        return userDao.findOne(id);
    }

    @Override
    @Transactional
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public void remove(String email) {
        userDao.deleteByEmail(email);
    }

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    private String generateActivationCode() {
        return UUID.randomUUID().toString();
    }

    private UserActivation createUserActivation(User user, String activationCode) {
        return new UserActivation(user, activationCode, user.getId());
    }

    private void createNotification(User user, String activationCode) {
        Date currentDate = new Date();
        Notification notification = new Notification(Channel.EMAIL, currentDate,
                user.getEmail(), String.format("Для активации вашего аккаунта пройдите по этой ссылке "
                + ACTIVATION_URL, activationCode));
        notificationDao.save(notification);
    }

    @Override
    @Transactional(propagation = REQUIRES_NEW)
    public void registerUser(User user) {
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
