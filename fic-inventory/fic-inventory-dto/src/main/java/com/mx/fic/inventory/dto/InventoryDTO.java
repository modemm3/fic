package com.mx.fic.inventory.dto;

import java.sql.Timestamp;

public class InventoryDTO implements BaseDTO{

	private static final long serialVersionUID = -1157351851454957502L;
	private Integer id;
	private Double currentStock;
	private ProductDTO productDTO;
	private Timestamp modificationDate;
	private Integer companyId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getCurrentStock() {
		return currentStock;
	}
	public void setCurrentStock(Double currentStock) {
		this.currentStock = currentStock;
	}
	public ProductDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
	public Timestamp getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Timestamp modificationDate) {
		this.modificationDate = modificationDate;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InventoryDTO [id=");
		builder.append(id);
		builder.append(", currentStock=");
		builder.append(currentStock);
		builder.append(", productDTO=");
		builder.append(productDTO);
		builder.append(", modificationDate=");
		builder.append(modificationDate);
		builder.append(", companyId=");
		builder.append(companyId);
		builder.append("]");
		return builder.toString();
	}

}
