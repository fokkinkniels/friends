package com.springdemovideo.springdemovideo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class Person {

    private final UUID id;

    private final String name;

    private UUID favoriteFood;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
        this.favoriteFood = null;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UUID getFavoriteFood() {
        return favoriteFood;
    }

    public void addFavoriteFood(UUID id) {
        this.favoriteFood = id;
    }
}
