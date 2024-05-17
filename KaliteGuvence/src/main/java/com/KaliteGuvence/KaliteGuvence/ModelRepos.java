package com.KaliteGuvence.KaliteGuvence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepos extends JpaRepository<Model,Long> {

}
