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

    @GetMapping(path = "{id}")
    public Optional<Subject> getSubject(@PathVariable("id") String id){
        return subjectService.getSubjectById(id);
    }

    @GetMapping
    public List<Subject> getAllSubject(){
        return subjectService.getAllSubjects();
    }

    @PostMapping
    public void createSubject(@RequestBody Subject subject){
        subjectService.createSubject(subject);
    }
}
