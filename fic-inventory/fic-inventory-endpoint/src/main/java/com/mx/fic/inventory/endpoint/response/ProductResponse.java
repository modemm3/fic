package com.mx.fic.inventory.endpoint.response;

import java.util.List;

import com.mx.fic.inventory.dto.ProductDTO;

public class ProductResponse {
	private List<ProductDTO> productDTOLst;
	private Message message;
	
	public List<ProductDTO> getProductDTOLst() {
		return productDTOLst;
	}
	public void setProductDTOLst(List<ProductDTO> productDTOLst) {
		this.productDTOLst = productDTOLst;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}

}
