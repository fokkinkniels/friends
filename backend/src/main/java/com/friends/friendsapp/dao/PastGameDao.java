package com.friends.friendsapp.dao;

import com.friends.friendsapp.model.PastGame;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PastGameDao extends CrudRepository<PastGame, String> {

    List<PastGame> findAllByUserId(String userid);
}
