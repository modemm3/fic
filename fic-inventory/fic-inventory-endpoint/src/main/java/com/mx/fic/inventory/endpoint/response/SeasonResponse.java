package com.mx.fic.inventory.endpoint.response;

import java.util.List;

import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.SeasonDTO;

public class SeasonResponse implements BaseDTO{

	private static final long serialVersionUID = 1998133177145630884L;
	private List<SeasonDTO> seasonDTOLst;
	private Message message;
	
	public List<SeasonDTO> getSeasonDTOLst() {
		return seasonDTOLst;
	}
	public void setSeasonDTOLst(List<SeasonDTO> seasonDTOLst) {
		this.seasonDTOLst = seasonDTOLst;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}

}
