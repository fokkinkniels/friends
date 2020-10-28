package com.friends.friendsapp.controller;

import com.friends.friendsapp.model.CategorySubject;
import com.friends.friendsapp.model.Subject;
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


    //Save a subject in a category
    @PostMapping
    public void saveCategorySubject(@NonNull @RequestBody CategorySubject categorySubject){
        categorySubjectService.saveCateGorySubject(categorySubject);
    }

    //Get all subjects in a category
    @GetMapping(path = "get/{id}")
    public List<Subject> getSubjects(@PathVariable("id") String id){
        return categorySubjectService.getAllSubjects(id);
    }

    //Save subjects in category
    @PostMapping(path = "add/{id}")
    public void saveSubjects(@PathVariable("id") String id, @RequestBody List<String> idList){
        categorySubjectService.saveAllSubjects(id, idList);
    }

    //delete subjects in category
    @DeleteMapping(path = "remove/{id}")
    public void removeSubjects(@PathVariable("id") String id, @RequestBody List<String> idList){
        categorySubjectService.removeSubjects(id, idList);
    }
}
