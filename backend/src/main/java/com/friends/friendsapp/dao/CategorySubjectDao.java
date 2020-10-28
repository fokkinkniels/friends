package com.friends.friendsapp.dao;

import com.friends.friendsapp.model.CategorySubject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategorySubjectDao extends CrudRepository<CategorySubject, String> {

    public List<CategorySubject> findAllByCategoryId(String categoryId);

    public List<CategorySubject> findAllBySubjectId(String subjectId);

    public CategorySubject findBySubjectIdAndCategoryId(String subjectId, String categoryId);
}
