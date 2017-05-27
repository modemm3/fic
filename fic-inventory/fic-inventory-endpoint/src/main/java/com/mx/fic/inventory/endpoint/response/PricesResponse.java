package com.mx.fic.inventory.endpoint.response;

import java.util.List;

import com.mx.fic.inventory.dto.PricesDTO;

public class PricesResponse {
	
	private List<PricesDTO> pricesDTOLst;
	private Message message;
	
	public List<PricesDTO> getPricesDTOLst() {
		return pricesDTOLst;
	}
	public void setPricesDTOLst(List<PricesDTO> pricesDTOLst) {
		this.pricesDTOLst = pricesDTOLst;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}

}
