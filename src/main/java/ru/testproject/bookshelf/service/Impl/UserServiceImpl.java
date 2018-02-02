package ru.testproject.bookshelf.service.Impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.bookshelf.dao.UserDao;
import ru.testproject.bookshelf.model.User;
import ru.testproject.bookshelf.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional
@Service
public class UserServiceImpl implements UserService {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(long id) {
        return userDao.findOne(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return Lists.newArrayList(userDao.findAll());
    }

    @Override
    public User save(User user) {

        return userDao.save(user);
    }

    @Override
    public List<User> remove(String email) {
        return userDao.deleteByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = getUserByEmail(email);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        UserDetails userDetails = new org.springframework.security.core.userdetails
                .User(user.getEmail(), user.getPassword(), true,
                true, true, true, authorities);
        return userDetails;
    }
}
