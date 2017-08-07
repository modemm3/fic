package com.mx.fic.inventory.endpoint.response;

import java.util.List;

import com.mx.fic.inventory.dto.OperationMasterDTO;

public class OperationMasterResponse {

	private List<OperationMasterDTO> operationMasterDTO;
	private Integer operationMasterId;
	private Message message;
	
	public List<OperationMasterDTO> getOperationMasterDTO() {
		return operationMasterDTO;
	}
	public void setOperationMasterDTO(List<OperationMasterDTO> operationMasterDTO) {
		this.operationMasterDTO = operationMasterDTO;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public Integer getOperationMasterId() {
		return operationMasterId;
	}
	public void setOperationMasterId(Integer operationMasterId) {
		this.operationMasterId = operationMasterId;
	}
	
}
