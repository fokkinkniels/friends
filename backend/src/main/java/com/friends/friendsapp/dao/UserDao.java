package com.friends.friendsapp.dao;

import com.friends.friendsapp.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao extends CrudRepository<User, Integer> {

}
