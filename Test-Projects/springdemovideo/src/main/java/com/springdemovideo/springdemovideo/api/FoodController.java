package com.springdemovideo.springdemovideo.api;

import com.springdemovideo.springdemovideo.model.Food;
import com.springdemovideo.springdemovideo.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestMapping("api/v1/food")
@RestController
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public void addFood(@NonNull @RequestBody Map<String, String> json){
        foodService.addFood(json.get("name"), json.get("color"));
    }

    @GetMapping
    public List<Food> getAllFood(){
        return  foodService.getAllFood();
    }

    @GetMapping(path = "{foodid}")
    public Food getFoodById(@PathVariable("foodid") UUID id){
        return foodService.getFoodById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{foodid}")
    public void deleteFoodById(@PathVariable("foodid") UUID id){
        foodService.deleteFood(id);
    }

    @PutMapping(path = "{foodid}")
    public void updateFood(@PathVariable("foodid") UUID id,
                           @NonNull @RequestBody Map<String, String> json){
        foodService.updateFood(id, json.get("name"), json.get("color"));
    }

}
