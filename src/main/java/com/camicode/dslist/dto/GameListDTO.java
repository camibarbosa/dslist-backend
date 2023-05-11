package com.camicode.dslist.dto;

import com.camicode.dslist.entities.GameList;

public class GameListDTO {
	private Long id;
	private String name;
	
	public GameListDTO() {
		
	}
	
	//copia os dados da entidade para o dto
	public GameListDTO(GameList entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}
