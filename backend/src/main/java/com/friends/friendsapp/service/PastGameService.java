package com.friends.friendsapp.service;

import com.friends.friendsapp.dao.PastGameDao;
import com.friends.friendsapp.model.PastGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


@Service
public class PastGameService {

    @Autowired
    private PastGameDao pastGameDao;

    public List<PastGame> findByUserId(String user_id){
        List<PastGame> pastGames = new ArrayList<>();
        pastGameDao.findAllByUserId(user_id).forEach(pastGames::add);
        if(!pastGames.isEmpty()){
            return pastGames;
        }
        else {
            return Collections.emptyList();
        }
    }

    public void addPastGame(PastGame pastGame) {
        pastGameDao.save(pastGame);
    }
}
