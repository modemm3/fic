package com.mx.fic.inventory.dto;

public class OperationsDTO implements BaseDTO{
	
	private static final long serialVersionUID = 4854466677134336550L;
	private Integer id;
	private ProductDTO productDTO;
	private Integer statusId;
	private Double stocks;
	private Integer timeUnitId;
	private Integer companyId;
	private Integer operationMasterId;
	private Double unitPrice;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ProductDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public Double getStocks() {
		return stocks;
	}
	public void setStocks(Double stocks) {
		this.stocks = stocks;
	}
	public Integer getTimeUnitId() {
		return timeUnitId;
	}
	public void setTimeUnitId(Integer timeUnitId) {
		this.timeUnitId = timeUnitId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getOperationMasterId() {
		return operationMasterId;
	}
	public void setOperationMasterId(Integer operationMasterId) {
		this.operationMasterId = operationMasterId;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OperationsDTO [id=");
		builder.append(id);
		builder.append(", productDTO=");
		builder.append(productDTO);
		builder.append(", statusId=");
		builder.append(statusId);
		builder.append(", stocks=");
		builder.append(stocks);
		builder.append(", timeUnitId=");
		builder.append(timeUnitId);
		builder.append(", companyId=");
		builder.append(companyId);
		builder.append(", operationMasterId=");
		builder.append(operationMasterId);
		builder.append(", unitPrice=");
		builder.append(unitPrice);
		builder.append("]");
		return builder.toString();
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((operationMasterId == null) ? 0 : operationMasterId.hashCode());
		result = prime * result + ((productDTO == null) ? 0 : productDTO.hashCode());
		result = prime * result + ((statusId == null) ? 0 : statusId.hashCode());
		result = prime * result + ((stocks == null) ? 0 : stocks.hashCode());
		result = prime * result + ((timeUnitId == null) ? 0 : timeUnitId.hashCode());
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OperationsDTO other = (OperationsDTO) obj;
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.companyId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (operationMasterId == null) {
			if (other.operationMasterId != null)
				return false;
		} else if (!operationMasterId.equals(other.operationMasterId))
			return false;
		if (productDTO == null) {
			if (other.productDTO != null)
				return false;
		} else if (!productDTO.equals(other.productDTO))
			return false;
		if (statusId == null) {
			if (other.statusId != null)
				return false;
		} else if (!statusId.equals(other.statusId))
			return false;
		if (stocks == null) {
			if (other.stocks != null)
				return false;
		} else if (!stocks.equals(other.stocks))
			return false;
		if (timeUnitId == null) {
			if (other.timeUnitId != null)
				return false;
		} else if (!timeUnitId.equals(other.timeUnitId))
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		return true;
	}
	
}
