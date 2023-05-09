package com.projetoAPI.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoAPI.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
