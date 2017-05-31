package com.mx.fic.inventory.endpoint.response;

import java.util.List;

import com.mx.fic.inventory.dto.TypePersonDTO;

public class TypePersonResponse {
	
	private List<TypePersonDTO> typePersonDTOLst;
	private Message message;
	
	public List<TypePersonDTO> getTypePersonDTOLst() {
		return typePersonDTOLst;
	}
	public void setTypePersonDTOLst(List<TypePersonDTO> typePersonDTOLst) {
		this.typePersonDTOLst = typePersonDTOLst;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}

}
