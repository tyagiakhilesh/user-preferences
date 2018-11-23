package com.akhilesh.learning.db.dao;

import com.akhilesh.learning.db.entity.UserEntity;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDao extends AbstractDAO<UserEntity> {
    public UserDao(final SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public UserEntity findById(final String userId) {
        return this.get(userId);
    }

    public String create(final UserEntity entity) {
        return this.persist(entity).getUserId();
    }

    public List<UserEntity> findAll() {
        return this.list(namedQuery("com.akhilesh.learning.db.entity.UserEntity.findAll"));
    }
}
