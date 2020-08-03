package com.javaguru.todolist.service;

import com.javaguru.todolist.domain.UserEntity;
import com.javaguru.todolist.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

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

    /* @JoinColumn example
    public void addTask(TaskEntity taskEntity, Long userId) {
        UserEntity user = findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found, id: " + userId));
        user.getTasks().add(taskEntity);
        userRepository.update(user);
    }
     */
    public UserEntity findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found, id: " + userId));
    }

}
