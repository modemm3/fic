package com.mx.fic.inventory.endpoint.response;

import java.util.List;

import com.mx.fic.inventory.dto.ValuationTypeDTO;

public class ValuationTypeResponse {
	
	private List<ValuationTypeDTO> valuationTypeLst;
	private Message message;
	
	public List<ValuationTypeDTO> getValuationTypeLst() {
		return valuationTypeLst;
	}
	public void setValuationTypeLst(List<ValuationTypeDTO> valuationTypeLst) {
		this.valuationTypeLst = valuationTypeLst;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}

}
