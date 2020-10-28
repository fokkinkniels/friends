package com.friends.friendsapp.service;

import com.friends.friendsapp.dao.CategorySubjectDao;
import com.friends.friendsapp.dao.SubjectDao;
import com.friends.friendsapp.model.CategorySubject;
import com.friends.friendsapp.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategorySubjectService {

    @Autowired
    CategorySubjectDao categorySubjectDao;
    @Autowired
    private SubjectDao subjectDao;

    public void saveCateGorySubject(CategorySubject categorySubject){
        categorySubjectDao.save(categorySubject);
    }

    public List<Subject> getAllSubjects(String id){
        List<CategorySubject> categorySubjects = new ArrayList<>();
        List<Subject> subjects = new ArrayList<>();

        categorySubjectDao.findAllByCategoryId(id).forEach(categorySubjects::add);

        for (CategorySubject categorySubject:
                categorySubjects) {
            subjectDao.findById(categorySubject.getSubjectId()).ifPresent(subjects::add);
        }

        return subjects;
    }

    public void saveAllSubjects(String id, List<String> idList){
        for (String subjectId:
                idList ) {
            CategorySubject categorySubject = new CategorySubject(id, subjectId);

            if(categorySubjectDao.findBySubjectIdAndCategoryId(subjectId, id) == null){
                categorySubjectDao.save(categorySubject);
            }
        }
    }

    public void removeSubjects(String id, List<String> idList) {

        if(!idList.isEmpty()){
            for (String subjectId:
                    idList ) {
                CategorySubject categorySubject = categorySubjectDao.findBySubjectIdAndCategoryId(subjectId, id);
                if(categorySubject != null) {
                    categorySubject.getId();
                    categorySubjectDao.deleteById(categorySubject.getId());
                }
            }
        }
    }
}
