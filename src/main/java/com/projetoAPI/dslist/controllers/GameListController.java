package com.projetoAPI.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoAPI.dslist.dto.GameListDTO;
import com.projetoAPI.dslist.dto.GameMinDTO;
import com.projetoAPI.dslist.services.GameListService;
import com.projetoAPI.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	@Autowired
	private GameListService gameListService;
	@Autowired
	private GameService gameService;
	
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	 }
	@GetMapping(value= "/{listId}/games")
	public List<GameMinDTO> findGames(@PathVariable Long listId){
		List<GameMinDTO> result = gameService.findByGameList(listId);
		return result;
	 }
}
