package com.akhilesh.learning.core;

import com.akhilesh.learning.db.dao.UserDao;
import com.akhilesh.learning.db.entity.UserEntity;

import java.util.List;

public class UserService {

    private final UserDao userDao;

    public UserService(final UserDao userDao) {
        this.userDao = userDao;
    }

    public UserEntity getUser(final String userId) {
        return  userDao.findById(userId);
    }

    public String createUser(final UserEntity entity) {
        return userDao.create(entity);
    }

    public List<UserEntity> getAllUsers() {
        return userDao.findAll();
    }
}
