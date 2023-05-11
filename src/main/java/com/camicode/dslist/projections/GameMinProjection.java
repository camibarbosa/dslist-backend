package com.camicode.dslist.projections;

public interface GameMinProjection {
	//metodos gets correspondente a consulta
	
	Long getId();
	String getTitle();
	Integer getGameYear();
	String getImgUrl();
	String getShortDescription();
	String getPosition();
}
