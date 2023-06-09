package com.projetoAPI.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.projetoAPI.dslist.dto.GameDTO;
import com.projetoAPI.dslist.dto.GameMinDTO;
import com.projetoAPI.dslist.entities.Game;
import com.projetoAPI.dslist.projections.GameMinProjection;
import com.projetoAPI.dslist.repositories.GameRepository;



@Component //Annotation que permite que essa classe torne parte do sistema spring como outras classes da biblioteca, podemos usar a annotation @Service
public class GameService {
	@Autowired //componentes da biblioteca se complementão para formar o sistema, aqui estou conectando o repository com o service usando essa annotation
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(@PathVariable Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(GameMinDTO::new).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByGameList(Long listId){
		List<GameMinProjection> games = gameRepository.searchByList(listId);
		List<GameMinDTO> dto = games.stream().map(GameMinDTO::new).toList();
		return dto;
	}
}
