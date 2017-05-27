package com.mx.fic.inventory.endpoint.response;

import java.util.List;

import com.mx.fic.inventory.dto.TypePriceDTO;

public class TypePriceResponse {
	
	private List<TypePriceDTO> typePriceDTOLst;
	private Message message;
	
	public List<TypePriceDTO> getTypePriceDTOLst() {
		return typePriceDTOLst;
	}
	public void setTypePriceDTOLst(List<TypePriceDTO> typePriceDTOLst) {
		this.typePriceDTOLst = typePriceDTOLst;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}

}
