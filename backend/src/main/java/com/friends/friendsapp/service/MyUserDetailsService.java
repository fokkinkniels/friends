package com.friends.friendsapp.service;

import com.friends.friendsapp.dao.UserDao;
import com.friends.friendsapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> user = userDao.findByUsername(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not Found: " + userName));

        return new org.springframework.security.core.userdetails.User(
                user.get().getUsername(),
                user.get().getPassword(),
                new ArrayList<>());
    }
}
