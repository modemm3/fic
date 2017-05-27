package com.mx.fic.inventory.endpoint.response;

import java.util.List;

import com.mx.fic.inventory.dto.MeasureUnitDTO;

public class MeasureUnitResponse {
	
	private List<MeasureUnitDTO> measureUnitDTOLst;
	private Message message;
	
	public List<MeasureUnitDTO> getMeasureUnitDTOLst() {
		return measureUnitDTOLst;
	}
	public void setMeasureUnitDTOLst(List<MeasureUnitDTO> measureUnitDTOLst) {
		this.measureUnitDTOLst = measureUnitDTOLst;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	

}
