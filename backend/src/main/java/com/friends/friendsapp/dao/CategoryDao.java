package com.friends.friendsapp.dao;

import com.friends.friendsapp.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDao extends CrudRepository<Category, String> {
}
