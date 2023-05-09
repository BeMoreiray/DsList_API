package com.projetoAPI.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projetoAPI.dslist.dto.GameMinDTO;
import com.projetoAPI.dslist.entities.Game;
import com.projetoAPI.dslist.repositories.GameRepository;

@Component //Annotation que permite que essa classe torne parte do sistema spring como outras classes da biblioteca, podemos usar a annotation @Service
public class GameService {
	@Autowired //componentes da biblioteca se complementão para formar o sistema, aqui estou conectando o repository com o service usando essa annotation
	private GameRepository gamerepository;
	
	public List<GameMinDTO> findAll(){
		List<Game> result = gamerepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
}
