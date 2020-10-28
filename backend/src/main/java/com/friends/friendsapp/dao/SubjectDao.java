package com.friends.friendsapp.dao;

import com.friends.friendsapp.model.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectDao extends CrudRepository<Subject, String> {
}
