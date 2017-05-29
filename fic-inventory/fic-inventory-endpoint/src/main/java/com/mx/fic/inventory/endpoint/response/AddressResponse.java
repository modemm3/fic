package com.mx.fic.inventory.endpoint.response;

import java.util.List;

import com.mx.fic.inventory.dto.AddressDTO;

public class AddressResponse {
	
	private List<AddressDTO> addressDTOLst;
	private Message message;
	
	public List<AddressDTO> getAddressDTOLst() {
		return addressDTOLst;
	}
	public void setAddressDTOLst(List<AddressDTO> addressDTOLst) {
		this.addressDTOLst = addressDTOLst;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}

}
