package com.sibacode.monitoring.example.grafanaprometheus.repository;


import com.sibacode.monitoring.example.grafanaprometheus.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity,String> {

    Boolean existsByUsername(String username);

    void deleteByUsername(String username);


}
