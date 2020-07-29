package com.javaguru.todolist.service;

import com.javaguru.todolist.domain.TaskEntity;
import com.javaguru.todolist.domain.UserEntity;
import com.javaguru.todolist.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    public void addTask(TaskEntity taskEntity, Long userId) {
        UserEntity user = findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found, id: " + userId));
        user.getTasks().add(taskEntity);
        userRepository.update(user);
    }

    private Optional<UserEntity> findById(Long userId) {
        return userRepository.findById(userId);
    }
}
