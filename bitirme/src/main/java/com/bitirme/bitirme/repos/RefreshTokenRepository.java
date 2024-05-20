package com.bitirme.bitirme.repos;

import com.bitirme.bitirme.entities.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {

    RefreshToken findByUserId(Long userId);

}
