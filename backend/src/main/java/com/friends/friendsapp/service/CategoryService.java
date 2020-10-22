package com.friends.friendsapp.service;

import com.friends.friendsapp.dao.CategoryDao;
import com.friends.friendsapp.logics.GenerateId;
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
    private GenerateId generateId = new GenerateId();

    public void addCategory(Category category) {
        category.setId(generateId.generateUniqueId());
        categoryDao.save(category);
    }

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        categoryDao.findAll().forEach(categories::add);
        return categories;
    }

    public Optional<Category> getCategoryById(int id) {
        return categoryDao.findById(id);
    }

    public void deleteCategoryById(int id) {
        categoryDao.deleteById(id);
    }

    public void updateUserById(int id, Category category) {
        category.setId(id);
        categoryDao.save(category);
    }
}
