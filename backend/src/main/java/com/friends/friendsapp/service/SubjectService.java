package com.friends.friendsapp.service;

import com.friends.friendsapp.dao.CategorySubjectDao;
import com.friends.friendsapp.dao.SubjectDao;
import com.friends.friendsapp.model.CategorySubject;
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
    @Autowired
    private CategorySubjectDao categorySubjectDao;


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

    public void updateSubject(String id, Subject subject) {
        subject.setId(id);
        subjectDao.save(subject);
    }

    public void deleteSubject(String id) {
        List<CategorySubject> categorySubjects = categorySubjectDao.findAllBySubjectId(id);
        if(!categorySubjects.isEmpty()) {
            categorySubjectDao.deleteAll(categorySubjects);
        }
        subjectDao.deleteById(id);
    }
}
