package com.friends.friendsapp.controller;

import com.friends.friendsapp.model.Category;
import com.friends.friendsapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void addCategory(@NonNull @RequestBody Category category){
        categoryService.addCategory(category);
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping(path = "{id}")
    public Optional<Category> getCategoryById(@PathVariable("id") int id){
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCategoryById(@PathVariable("id") int id){
        categoryService.deleteCategoryById(id);
    }

    @PutMapping(path ="{id}")
    public void updateUserById(@PathVariable("id") int id,@NonNull @RequestBody Category category){
        categoryService.updateUserById(id, category);
    }
}
