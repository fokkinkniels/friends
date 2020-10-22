package com.friends.friendsapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private final int id;

    private final String username;

    public User(@JsonProperty("id") int id,
                @JsonProperty("username") String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
