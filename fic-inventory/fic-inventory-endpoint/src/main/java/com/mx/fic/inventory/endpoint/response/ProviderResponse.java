package com.mx.fic.inventory.endpoint.response;

import java.util.List;

import com.mx.fic.inventory.dto.ProviderDTO;

public class ProviderResponse {

	private List<ProviderDTO> providerDTOLst;
	private Message message;
	
	public List<ProviderDTO> getProviderDTOLst() {
		return providerDTOLst;
	}
	public void setProviderDTOLst(List<ProviderDTO> providerDTOLst) {
		this.providerDTOLst = providerDTOLst;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
}
