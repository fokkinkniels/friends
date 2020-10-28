package com.friends.friendsapp.service;

import com.friends.friendsapp.dao.UserDao;
import com.friends.friendsapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void addUser(User user){
        userDao.save(user);
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userDao.findAll().forEach(users::add);
        return users;
    }

    public Optional<User> getUserById(String id){
        return userDao.findById(id);
    }

    public void deleteUser(String id){
        userDao.deleteById(id);
    }

    public void updateUser(String id, User newUser){
        newUser.setId(id);
        userDao.save(newUser);
    }
}
