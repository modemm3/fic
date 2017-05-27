package com.mx.fic.inventory.dto;

public class ProductDTO implements BaseDTO {
	
	private static final long serialVersionUID = 7661454601994813052L;
	
	private Integer id;
	private String name;
	private String description;
	private String barCode;
	private MeasureUnitDTO measureUnitDTO;
	private StatusDTO statusDTO;
	private Double minimunStock;
	private Double maximumStock;
	private CompanyDTO companyDTO;
	private PaginationDTO paginationDTO;		
	
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
	public MeasureUnitDTO getMeasureUnitDTO() {
		return measureUnitDTO;
	}
	public void setMeasureUnitDTO(MeasureUnitDTO measureUnitDTO) {
		this.measureUnitDTO = measureUnitDTO;
	}
	public StatusDTO getStatusDTO() {
		return statusDTO;
	}
	public void setStatusDTO(StatusDTO statusDTO) {
		this.statusDTO = statusDTO;
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
	public CompanyDTO getCompanyDTO() {
		return companyDTO;
	}
	public void setCompanyDTO(CompanyDTO companyDTO) {
		this.companyDTO = companyDTO;
	}
	
	public PaginationDTO getPaginationDTO() {
		return paginationDTO;
	}
	public void setPaginationDTO(PaginationDTO paginationDTO) {
		this.paginationDTO = paginationDTO;
	}
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", description=" + description + ", barCode=" + barCode
				+ ", measureUnitDTO=" + measureUnitDTO + ", statusDTO=" + statusDTO + ", minimunStock=" + minimunStock
				+ ", maximumStock=" + maximumStock + ", companyDTO=" + companyDTO + "]";
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barCode == null) ? 0 : barCode.hashCode());
		result = prime * result + ((companyDTO == null) ? 0 : companyDTO.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((maximumStock == null) ? 0 : maximumStock.hashCode());
		result = prime * result + ((measureUnitDTO == null) ? 0 : measureUnitDTO.hashCode());
		result = prime * result + ((minimunStock == null) ? 0 : minimunStock.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((statusDTO == null) ? 0 : statusDTO.hashCode());
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
		if (companyDTO == null) {
			if (other.companyDTO != null)
				return false;
		} else if (!companyDTO.equals(other.companyDTO))
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
		if (measureUnitDTO == null) {
			if (other.measureUnitDTO != null)
				return false;
		} else if (!measureUnitDTO.equals(other.measureUnitDTO))
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
		if (statusDTO == null) {
			if (other.statusDTO != null)
				return false;
		} else if (!statusDTO.equals(other.statusDTO))
			return false;
		return true;
	}
	
}
