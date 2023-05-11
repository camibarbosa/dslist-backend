package com.camicode.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.camicode.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{
	
}
