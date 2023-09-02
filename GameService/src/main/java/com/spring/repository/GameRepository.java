package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

}
