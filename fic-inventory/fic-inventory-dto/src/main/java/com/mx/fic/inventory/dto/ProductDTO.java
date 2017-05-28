package com.mx.fic.inventory.dto;

public class ProductDTO implements BaseDTO {
	
	private static final long serialVersionUID = 7661454601994813052L;
	
	private Integer id;
	private String name;
	private String description;
	private String barCode;
	private Integer measureUnitId;
	private Integer statusId;
	private Double minimunStock;
	private Double maximumStock;
	private Integer companyId;
	private PaginationDTO paginationDTO;	
	
	public ProductDTO() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public Double getMinimunStock() {
		return minimunStock;
	}
	public void setMinimunStock(Double minimunStock) {
		this.minimunStock = minimunStock;
	}
	public Double getMaximumStock() {
		return maximumStock;
	}
	public void setMaximumStock(Double maximumStock) {
		this.maximumStock = maximumStock;
	}
	public Integer getMeasureUnitId() {
		return measureUnitId;
	}
	public void setMeasureUnitId(Integer measureUnitId) {
		this.measureUnitId = measureUnitId;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public PaginationDTO getPaginationDTO() {
		return paginationDTO;
	}
	public void setPaginationDTO(PaginationDTO paginationDTO) {
		this.paginationDTO = paginationDTO;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barCode == null) ? 0 : barCode.hashCode());
		result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((maximumStock == null) ? 0 : maximumStock.hashCode());
		result = prime * result + ((measureUnitId == null) ? 0 : measureUnitId.hashCode());
		result = prime * result + ((minimunStock == null) ? 0 : minimunStock.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((paginationDTO == null) ? 0 : paginationDTO.hashCode());
		result = prime * result + ((statusId == null) ? 0 : statusId.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDTO other = (ProductDTO) obj;
		if (barCode == null) {
			if (other.barCode != null)
				return false;
		} else if (!barCode.equals(other.barCode))
			return false;
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.companyId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (maximumStock == null) {
			if (other.maximumStock != null)
				return false;
		} else if (!maximumStock.equals(other.maximumStock))
			return false;
		if (measureUnitId == null) {
			if (other.measureUnitId != null)
				return false;
		} else if (!measureUnitId.equals(other.measureUnitId))
			return false;
		if (minimunStock == null) {
			if (other.minimunStock != null)
				return false;
		} else if (!minimunStock.equals(other.minimunStock))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (paginationDTO == null) {
			if (other.paginationDTO != null)
				return false;
		} else if (!paginationDTO.equals(other.paginationDTO))
			return false;
		if (statusId == null) {
			if (other.statusId != null)
				return false;
		} else if (!statusId.equals(other.statusId))
			return false;
		return true;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductDTO [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", barCode=");
		builder.append(barCode);
		builder.append(", measureUnitId=");
		builder.append(measureUnitId);
		builder.append(", statusId=");
		builder.append(statusId);
		builder.append(", minimunStock=");
		builder.append(minimunStock);
		builder.append(", maximumStock=");
		builder.append(maximumStock);
		builder.append(", companyId=");
		builder.append(companyId);
		builder.append(", paginationDTO=");
		builder.append(paginationDTO);
		builder.append("]");
		return builder.toString();
	}
}
