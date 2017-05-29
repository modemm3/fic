package com.mx.fic.inventory.endpoint.response;

import java.util.List;

import com.mx.fic.inventory.dto.MovementConceptDTO;

public class MovementConceptResponse {
	
	private List<MovementConceptDTO> movementConceptLst;
	private Message message;
	
	public List<MovementConceptDTO> getMovementConceptLst() {
		return movementConceptLst;
	}
	public void setMovementConceptLst(List<MovementConceptDTO> movementConceptLst) {
		this.movementConceptLst = movementConceptLst;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
}
