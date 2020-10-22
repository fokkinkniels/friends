package com.friends.friendsapp.dao;

import com.friends.friendsapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {

}
