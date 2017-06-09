package com.mx.fic.inventory.request;

public class InventoryOperationRequest {
	
	private Integer companyId;
	private Integer productId;
	
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InventoryOperationRequest [companyId=");
		builder.append(companyId);
		builder.append(", productId=");
		builder.append(productId);
		builder.append("]");
		return builder.toString();
	}

}
