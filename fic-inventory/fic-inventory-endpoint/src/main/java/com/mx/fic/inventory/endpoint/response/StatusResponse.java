package com.mx.fic.inventory.endpoint.response;

import java.util.List;

import com.mx.fic.inventory.dto.StatusDTO;

public class StatusResponse {

	private List<StatusDTO> statusDTOLst;
	private Message message;
	
	public List<StatusDTO> getStatusDTOLst() {
		return statusDTOLst;
	}
	public void setStatusDTOLst(List<StatusDTO> statusDTOLst) {
		this.statusDTOLst = statusDTOLst;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
	
}
