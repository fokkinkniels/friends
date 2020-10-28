package com.friends.friendsapp.service;

import com.friends.friendsapp.dao.CategorySubjectDao;
import com.friends.friendsapp.model.CategorySubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorySubjectService {

    @Autowired
    CategorySubjectDao categorySubjectDao;

    public void saveCateGorySubject(CategorySubject categorySubject){
        categorySubjectDao.save(categorySubject);
    }
}
