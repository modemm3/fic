package com.mx.fic.inventory.endpoint.response;

import java.util.List;

import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.ValuationDTO;

public class ValuationResponse implements BaseDTO {
	
	private static final long serialVersionUID = 4944203449152662335L;
	List<ValuationDTO> valuationDTOLst;
	private Message message;
	
	public List<ValuationDTO> getValuationDTOLst() {
		return valuationDTOLst;
	}
	public void setValuationDTOLst(List<ValuationDTO> valuationDTOLst) {
		this.valuationDTOLst = valuationDTOLst;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
}
