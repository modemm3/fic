package com.mx.fic.inventory.endpoint.response;

import java.util.List;

import com.mx.fic.inventory.dto.OperationsDTO;

public class OperationsResponse {
	
	private List<OperationsDTO> operationsDTOLst;
	private Message message;
	
	public List<OperationsDTO> getOperationsDTOLst() {
		return operationsDTOLst;
	}
	public void setOperationsDTOLst(List<OperationsDTO> operationsDTOLst) {
		this.operationsDTOLst = operationsDTOLst;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}

}
