package com.camicode.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camicode.dslist.dto.GameListDTO;
import com.camicode.dslist.entities.GameList;
import com.camicode.dslist.projections.GameMinProjection;
import com.camicode.dslist.repositories.GameListRepository;
import com.camicode.dslist.repositories.GameRepository;

@Service 
public class GameListService {
	//chamar o repository
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true) 
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll(); //gera consulta no bd para buscar todos os games
		return result.stream().map(x -> new GameListDTO(x)).toList(); //transforma uma lista de games 
	}
	
	@Transactional
	//método para atualizar os jogos na lista
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		//metodo para remover um obj de uma posicao e adicioná-lo em uma nova posicao
		 GameMinProjection obj = list.remove(sourceIndex);
		 list.add(destinationIndex, obj);
		 
		 //método para achar o valor minimo e maximo da posicao
		 int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		 int max = sourceIndex > destinationIndex ? destinationIndex : sourceIndex;
		 
		 for(int i = min; i <= max; i++ ) {                     //id do jogo
			 gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		 }
	}
}
