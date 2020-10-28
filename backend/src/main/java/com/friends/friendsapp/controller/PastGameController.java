package com.friends.friendsapp.controller;

import com.friends.friendsapp.model.PastGame;
import com.friends.friendsapp.model.User;
import com.friends.friendsapp.service.PastGameService;
import com.friends.friendsapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/user/past_games")
@RestController
public class PastGameController {

    PastGameService pastGameService;

    @Autowired
    public PastGameController(PastGameService pastGameService) {
        this.pastGameService = pastGameService;
    }

    //Get all past games by user id
    @GetMapping(path = "{id}")
    public List<PastGame> getUserById(@PathVariable("id") String userId){
        return pastGameService.findByUserId(userId);
    }

    @PostMapping
    public void addPastGame(@RequestBody PastGame pastGame){
        pastGameService.addPastGame(pastGame);
    }
}
