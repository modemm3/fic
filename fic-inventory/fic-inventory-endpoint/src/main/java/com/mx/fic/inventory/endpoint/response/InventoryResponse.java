package com.mx.fic.inventory.endpoint.response;

import java.util.List;

import com.mx.fic.inventory.dto.InventoryDTO;

public class InventoryResponse {
	
	private List<InventoryDTO> inventoryDTOLst;
	private Message message;
	
	public List<InventoryDTO> getInventoryDTOLst() {
		return inventoryDTOLst;
	}
	public void setInventoryDTOLst(List<InventoryDTO> inventoryDTOLst) {
		this.inventoryDTOLst = inventoryDTOLst;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}

}
