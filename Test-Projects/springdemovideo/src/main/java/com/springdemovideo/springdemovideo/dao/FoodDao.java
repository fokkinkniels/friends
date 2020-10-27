package com.springdemovideo.springdemovideo.dao;

import com.springdemovideo.springdemovideo.model.Food;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FoodDao {


    int insertFood(UUID id, String food, String color);

    default int insertFood(String food, String color){
        UUID id = UUID.randomUUID();
        return insertFood(id, food, color);
    }

    List<Food> selectAllFood();

    Optional<Food> selectFoodById(UUID id);

    int deleteFoodById(UUID id);

    int updateFoodById(UUID id, String food, String color);
}
