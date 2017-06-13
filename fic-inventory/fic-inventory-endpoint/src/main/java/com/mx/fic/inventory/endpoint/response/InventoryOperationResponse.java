package com.mx.fic.inventory.endpoint.response;

import java.util.List;
import com.mx.fic.inventory.dto.InventoryOperationDTO;

public class InventoryOperationResponse {
	
	private List<InventoryOperationDTO> InventoryOperationDTO;
	private Message message;
	
	public List<InventoryOperationDTO> getInventoryOperationDTO() {
		return InventoryOperationDTO;
	}
	public void setInventoryOperationDTO(List<InventoryOperationDTO> inventoryOperationDTO) {
		InventoryOperationDTO = inventoryOperationDTO;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}

}
