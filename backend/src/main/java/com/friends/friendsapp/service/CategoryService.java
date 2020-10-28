package com.friends.friendsapp.service;

import com.friends.friendsapp.dao.CategoryDao;
import com.friends.friendsapp.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public void addCategory(Category category) {
        categoryDao.save(category);
    }

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        categoryDao.findAll().forEach(categories::add);
        return categories;
    }

    public Optional<Category> getCategoryById(String id) {
        return categoryDao.findById(id);
    }

    public void deleteCategoryById(String id) {
        categoryDao.deleteById(id);
    }

    public void updateUserById(String id, Category category) {
        category.setId(id);
        categoryDao.save(category);
    }
}
