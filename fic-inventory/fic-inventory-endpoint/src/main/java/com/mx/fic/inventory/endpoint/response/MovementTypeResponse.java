package com.mx.fic.inventory.endpoint.response;

import java.util.List;

import com.mx.fic.inventory.dto.MovementTypeDTO;

public class MovementTypeResponse {
	
	private List<MovementTypeDTO> movementTypeDTOLst;
	private Message message;
	
	public List<MovementTypeDTO> getMovementTypeDTOLst() {
		return movementTypeDTOLst;
	}
	public void setMovementTypeDTOLst(List<MovementTypeDTO> movementTypeDTOLst) {
		this.movementTypeDTOLst = movementTypeDTOLst;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
}
