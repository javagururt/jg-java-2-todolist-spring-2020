package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    UserEntity save(UserEntity userEntity);

    Optional<UserEntity> findById(Long id);

    List<UserEntity> findAll();

    void update(UserEntity userEntity);
}
