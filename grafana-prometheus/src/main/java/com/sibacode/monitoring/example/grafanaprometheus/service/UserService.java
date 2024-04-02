package com.sibacode.monitoring.example.grafanaprometheus.service;

import com.sibacode.monitoring.example.grafanaprometheus.model.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findAll();

    void save(UserEntity userEntity) throws Exception;

    void delete(String username) throws Exception;
}
