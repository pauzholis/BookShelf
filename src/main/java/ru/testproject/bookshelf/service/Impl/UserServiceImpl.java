//package ru.testproject.bookshelf.service.Impl;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import ru.testproject.bookshelf.dao.UserDao;
//import ru.testproject.bookshelf.model.User;
//import ru.testproject.bookshelf.service.UserService;
//
//@Repository
//@Transactional
//@Service
//public class UserServiceImpl implements UserService {
//
//    private final UserDao userDao;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    public UserServiceImpl(UserDao userDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userDao = userDao;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//
//    @Override
//    public void save(User user) {
//        userDao.save(user);
//    }
//
//    @Override
//    public User findByUsername(String email) {
//        return userDao.getUserByEmail(email);
//    }
//}
