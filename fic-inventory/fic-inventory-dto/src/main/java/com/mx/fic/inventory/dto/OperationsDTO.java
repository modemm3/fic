package com.mx.fic.inventory.dto;

import java.sql.Timestamp;

public class OperationsDTO implements BaseDTO{
	
	private static final long serialVersionUID = 4854466677134336550L;
	private Integer id;
	private ProductDTO productDTO;
	private Integer movementTypeId;
	private Integer statusId;
	private Timestamp creationDate;
	private Double stocks;
	private String folioDocument;
	private Integer timeUnitId;
	private Integer deliveryTime;
	private Integer providerId;
	private Integer companyId;
	private Double unitPrice;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMovementTypeId() {
		return movementTypeId;
	}
	public void setMovementTypeId(Integer movementTypeId) {
		this.movementTypeId = movementTypeId;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public Double getStocks() {
		return stocks;
	}
	public void setStocks(Double stocks) {
		this.stocks = stocks;
	}
	public String getFolioDocument() {
		return folioDocument;
	}
	public void setFolioDocument(String folioDocument) {
		this.folioDocument = folioDocument;
	}
	public Integer getTimeUnitId() {
		return timeUnitId;
	}
	public void setTimeUnitId(Integer timeUnitId) {
		this.timeUnitId = timeUnitId;
	}
	public Integer getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Integer deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public Integer getProviderId() {
		return providerId;
	}
	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public ProductDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
}
