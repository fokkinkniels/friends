package com.friends.friendsapp.service;

import com.friends.friendsapp.dao.UserDao;
import com.friends.friendsapp.logics.GenerateId;
import com.friends.friendsapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    private GenerateId generateId = new GenerateId();

    public void addUser(User user){
        user.setId(generateId.generateUniqueId());
        userDao.save(user);
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userDao.findAll().forEach(users::add);
        return users;
    }

    public Optional<User> getUserById(int id){
        return userDao.findById(id);
    }

    public void deleteUser(int id){
        userDao.deleteById(id);
    }

    public void updateUser(int id, User newUser){
        newUser.setId(id);
        userDao.save(newUser);
    }
}
