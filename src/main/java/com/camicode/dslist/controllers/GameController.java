package com.camicode.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camicode.dslist.dto.GameDTO;
import com.camicode.dslist.dto.GameMinDTO;
import com.camicode.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
//disponibiliza a api
public class GameController {
	
	//injeção de service
	@Autowired
	private GameService gameService;
	
	@GetMapping(value = "/{id}")
	public GameDTO finById(@PathVariable Long id){
		GameDTO result = gameService.findById(id);
		return result;
	}
	
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
}
