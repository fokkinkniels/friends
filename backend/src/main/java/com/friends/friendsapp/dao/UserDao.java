package com.friends.friendsapp.dao;

import com.friends.friendsapp.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {

    int insertUser(int id, User user);

    default int insertUser(User user){
        int id = generateUniqueId();
        return insertUser(id, user);
    }

    List<User> selectAllUsers();

    Optional<User> selectUserById(int id);

    int deleteUserById(int id);

    int updateUserById(int id, User user);

    default int generateUniqueId() {
        UUID idOne = UUID.randomUUID();
        UUID idTwo = UUID.randomUUID();
        String str=""+idOne+idTwo;
        int uid=str.hashCode();
        String filterStr=""+uid;
        str=filterStr.replaceAll("-", "");
        return Integer.parseInt(str);
    }
}
