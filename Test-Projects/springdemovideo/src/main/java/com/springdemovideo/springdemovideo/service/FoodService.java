package com.springdemovideo.springdemovideo.service;

import com.springdemovideo.springdemovideo.dao.FoodDao;
import com.springdemovideo.springdemovideo.dao.PersonDao;
import com.springdemovideo.springdemovideo.model.Food;
import com.springdemovideo.springdemovideo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FoodService {

    private final FoodDao foodDao;

    @Autowired
    public FoodService(@Qualifier("postgres-food")FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    public int addFood(String food, String color){
        return foodDao.insertFood(food, color);
    }

    public List<Food> getAllFood(){
        return foodDao.selectAllFood();
    }

    public Optional<Food> getFoodById(UUID id){
        return foodDao.selectFoodById(id);
    }

    public int deleteFood(UUID id){
        return foodDao.deleteFoodById(id);
    }

    public int updateFood(UUID id, String newFood, String color) {
        return foodDao.updateFoodById(id, newFood, color);
    }
}
