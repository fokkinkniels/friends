package com.friends.friendsapp.controller;

import com.friends.friendsapp.model.Subject;
import com.friends.friendsapp.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/subject")
public class SubjectController {

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    private SubjectService subjectService;

    //get subject by id
    @GetMapping(path = "{id}")
    public Optional<Subject> getSubject(@PathVariable("id") String id){
        return subjectService.getSubjectById(id);
    }

    //get all subjects
    @GetMapping
    public List<Subject> getAllSubject(){
        return subjectService.getAllSubjects();
    }

    //save a subject
    @PostMapping
    public void createSubject(@RequestBody Subject subject){
        subjectService.createSubject(subject);
    }

    @PutMapping(path = "{id}")
    public void updateSubject(@PathVariable String id, @RequestBody Subject subject){
        subjectService.updateSubject(id, subject);
    }

    @DeleteMapping(path = "{id}")
    public void deleteSubjectById(@PathVariable String id){
        subjectService.deleteSubject(id);
    }
}
