//package ru.testproject.bookshelf.service.Impl;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.transaction.annotation.Transactional;
//import ru.testproject.bookshelf.dao.UserDao;
//import ru.testproject.bookshelf.model.User;
//import java.util.HashSet;
//import java.util.Set;
//
//
//public class UserDetailsServiceImpl implements UserDetailsService {
//    private final UserDao userDao;
//
//    @Autowired
//    public UserDetailsServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userDao.getUserByEmail(email);
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        grantedAuthorities.add(new SimpleGrantedAuthority("User"));
//        org.springframework.security.core.userdetails.User newUser =
//                new org.springframework.security.core.userdetails
//                        .User(user.getEmail(), user.getPassword(), grantedAuthorities);
//        return newUser;
//    }
//}
