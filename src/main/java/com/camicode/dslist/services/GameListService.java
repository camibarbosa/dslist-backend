package com.camicode.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.camicode.dslist.dto.GameListDTO;
import com.camicode.dslist.entities.GameList;
import com.camicode.dslist.repositories.GameListRepository;

@Service 
public class GameListService {
	//chamar o repository
	@Autowired
	private GameListRepository gameRepository;
	
	@Transactional(readOnly = true) 
	public List<GameListDTO> findAll(){
		List<GameList> result = gameRepository.findAll(); //gera consulta no bd para buscar todos os games
		return result.stream().map(x -> new GameListDTO(x)).toList(); //transforma uma lista de games 
	}
}
