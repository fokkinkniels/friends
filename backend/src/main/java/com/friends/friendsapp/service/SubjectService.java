package com.friends.friendsapp.service;

import com.friends.friendsapp.dao.SubjectDao;
import com.friends.friendsapp.model.Subject;
import com.friends.friendsapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectDao subjectDao;


    public void createSubject(Subject subject){
        subjectDao.save(subject);
    }

    public Optional<Subject> getSubjectById(String id){
        return subjectDao.findById(id);
    }

    public List<Subject> getAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        subjectDao.findAll().forEach(subjects::add);
        return subjects;
    }
}
