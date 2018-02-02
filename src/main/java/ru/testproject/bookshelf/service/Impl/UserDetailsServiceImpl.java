package ru.testproject.bookshelf.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.bookshelf.dao.UserDao;
import ru.testproject.bookshelf.model.User;
import java.util.ArrayList;
import java.util.Collection;

@Repository
@Transactional
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDao userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.getUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("user " + email + " was not found");
        } else {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            UserDetails userDetails = new org.springframework.security.core.userdetails
                    .User(user.getEmail(), user.getPassword(), true,
                    true, true, true, authorities);
            return userDetails;
        }
    }
}
