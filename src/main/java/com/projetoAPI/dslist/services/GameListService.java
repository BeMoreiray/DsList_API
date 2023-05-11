package com.projetoAPI.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.projetoAPI.dslist.dto.GameListDTO;
import com.projetoAPI.dslist.entities.GameList;
import com.projetoAPI.dslist.repositories.GameListRepository;



@Component 
public class GameListService {
	@Autowired
	private GameListRepository gameListRepository;
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream().map(GameListDTO::new).toList();
		return dto;
	}
}
