package com.friends.friendsapp.dao;

import com.friends.friendsapp.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDao extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String userName);
}
