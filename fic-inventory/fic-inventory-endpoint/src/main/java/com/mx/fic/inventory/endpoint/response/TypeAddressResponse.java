package com.mx.fic.inventory.endpoint.response;

import java.util.List;

import com.mx.fic.inventory.dto.TypeAddressDTO;

public class TypeAddressResponse {
	
	private List<TypeAddressDTO> typeAddressDTOLst;
	private Message message;
	
	public List<TypeAddressDTO> getTypeAddressDTOLst() {
		return typeAddressDTOLst;
	}
	public void setTypeAddressDTOLst(List<TypeAddressDTO> typeAddressDTOLst) {
		this.typeAddressDTOLst = typeAddressDTOLst;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
}
