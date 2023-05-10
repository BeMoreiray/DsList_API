package com.projetoAPI.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoAPI.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
