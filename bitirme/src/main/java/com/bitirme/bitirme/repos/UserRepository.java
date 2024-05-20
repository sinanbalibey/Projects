package com.bitirme.bitirme.repos;

import com.bitirme.bitirme.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


    User findByUserName(String userName);
}
