package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.TaskEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
@Profile("hibernate")
@Transactional
class HibernateTaskRepository implements TaskRepository {

    private final SessionFactory sessionFactory;

    HibernateTaskRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public TaskEntity save(TaskEntity taskEntity) {
        sessionFactory.getCurrentSession().save(taskEntity);
        return taskEntity;
    }

    @Override
    public Optional<TaskEntity> findTaskById(Long id) {
        TaskEntity entity = sessionFactory.getCurrentSession().find(TaskEntity.class, id);
        return Optional.ofNullable(entity);
    }

    @Override
    public Optional<TaskEntity> findTaskByName(String name) {
        try {
            TaskEntity task = (TaskEntity) sessionFactory.getCurrentSession().createQuery("SELECT t FROM TaskEntity t WHERE t.name=:name")
                    .setParameter("name", name)
                    .getSingleResult();
            return Optional.ofNullable(task);
        } catch (NoResultException exception) {
            return Optional.empty();
        }
    }

    @Override
    public List<TaskEntity> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = currentSession.getCriteriaBuilder();
        CriteriaQuery<TaskEntity> query = builder.createQuery(TaskEntity.class);
        Root<TaskEntity> root = query.from(TaskEntity.class);
        query.select(root);
        return currentSession.createQuery(query).getResultList();
    }

    @Override
    public void update(TaskEntity taskEntity) {
        sessionFactory.getCurrentSession().update(taskEntity);
    }
}
