package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.UserEntity;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
class HibernateUserRepository implements UserRepository {

    private final SessionFactory sessionFactory;

    HibernateUserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        sessionFactory.getCurrentSession().save(userEntity);
        return userEntity;
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        UserEntity userEntity = sessionFactory.getCurrentSession().find(UserEntity.class, id);
        return Optional.ofNullable(userEntity);
    }

    @Override
    public List<UserEntity> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(UserEntity.class).list();
    }

    @Override
    public void update(UserEntity userEntity) {
        sessionFactory.getCurrentSession().update(userEntity);
    }
}
