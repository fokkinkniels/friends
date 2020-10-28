package com.friends.friendsapp.controller;

import com.friends.friendsapp.model.Category;
import com.friends.friendsapp.model.Subject;
import com.friends.friendsapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/category")
@RestController
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    //Create category
    @PostMapping
    public void addCategory(@NonNull @RequestBody Category category){
        categoryService.addCategory(category);
    }


    //Get all categories
    @GetMapping(path = "/getall")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }


    //Get category by id
    @GetMapping(path = "{id}")
    public Optional<Category> getCategoryById(@PathVariable("id") String id){
        return categoryService.getCategoryById(id);
    }


    //delete category by id
    @DeleteMapping(path = "{id}")
    public void deleteCategoryById(@PathVariable("id") String id){
        categoryService.deleteCategoryById(id);
    }


    //Update category by id
    @PutMapping(path ="{id}")
    public void updateUserById(@PathVariable("id") String id,@NonNull @RequestBody Category category){
        categoryService.updateUserById(id, category);
    }

}
