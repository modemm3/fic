package com.mx.fic.inventory.endpoint.response;

import java.util.List;

import com.mx.fic.inventory.dto.TimeUnitDTO;

public class TimeUnitResponse {

	List<TimeUnitDTO> timeUnitDTOLst;
	private Message message;
	
	public List<TimeUnitDTO> getTimeUnitDTOLst() {
		return timeUnitDTOLst;
	}
	public void setTimeUnitDTOLst(List<TimeUnitDTO> timeUnitDTOLst) {
		this.timeUnitDTOLst = timeUnitDTOLst;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
}
