package com.camicode.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camicode.dslist.dto.GameListDTO;
import com.camicode.dslist.dto.GameMinDTO;
import com.camicode.dslist.services.GameListService;
import com.camicode.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
//disponibiliza a api
public class GameListController {
	
	//injeção de service
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId){
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
}
