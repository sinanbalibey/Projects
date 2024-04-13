package com.senlikag.senlikagibb1.repository;


import com.senlikag.senlikagibb1.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location,Long> {

    List<Location> findByTownId(String townId);
}
