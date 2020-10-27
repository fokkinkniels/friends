package com.springdemovideo.springdemovideo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Food {

    private final UUID foodID;

    private final String name;

    private final String color;

    public Food(@JsonProperty("foodID") UUID foodID,
                @JsonProperty("name")String name,
                @JsonProperty("color") String color) {
        this.foodID = foodID;
        this.name = name;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public UUID getFoodID() {
        return foodID;
    }
}
