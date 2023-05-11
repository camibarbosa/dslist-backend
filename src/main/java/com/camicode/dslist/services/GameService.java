package com.camicode.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camicode.dslist.dto.GameDTO;
import com.camicode.dslist.dto.GameMinDTO;
import com.camicode.dslist.entities.Game;
import com.camicode.dslist.projections.GameMinProjection;
import com.camicode.dslist.repositories.GameRepository;

@Service 
public class GameService {
	//chamar o repository
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true) //nao bloqueia o bd na escrita
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get(); //busca no bd o game pelo id
		GameDTO dto = new GameDTO(result); //converte para dto
		return dto;
	}
	
	@Transactional(readOnly = true) 
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll(); //gera consulta no bd para buscar todos os games
		return result.stream().map(x -> new GameMinDTO(x)).toList(); //transforma uma lista de games 
	}
	
	//retorna games desta lista
	@Transactional(readOnly = true) 
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList(); //transforma uma lista de games em dto 
	}
}
