package com.friends.friendsapp.controller;

import com.friends.friendsapp.model.CategorySubject;
import com.friends.friendsapp.service.CategorySubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category/subject")
public class CategorySubjectController {

    @Autowired
    public CategorySubjectController(CategorySubjectService categorySubjectService) {
        this.categorySubjectService = categorySubjectService;
    }
    private CategorySubjectService categorySubjectService;


    @PostMapping
    public void saveCategorySubject(@NonNull @RequestBody CategorySubject categorySubject){
        categorySubjectService.saveCateGorySubject(categorySubject);
    }
}
