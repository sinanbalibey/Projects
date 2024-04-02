package com.sibacode.monitoring.example.grafanaprometheus.service;

import com.sibacode.monitoring.example.grafanaprometheus.model.UserEntity;
import com.sibacode.monitoring.example.grafanaprometheus.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(UserEntity userEntity) throws Exception {
        if (existsByUsername(userEntity.getUsername())) {
            throw new Exception("This username already exists = " + userEntity.getUsername());
        }
        userRepository.save(userEntity);
    }

    @Override
    public void delete(String username) throws Exception {
        if (!existsByUsername(username)) {
            throw new Exception("No user found to delete with this username = " + username);
        }
        userRepository.deleteByUsername(username);
    }

    private Boolean existsByUsername(String username) {
        return this.userRepository.existsByUsername(username);
    }
}
