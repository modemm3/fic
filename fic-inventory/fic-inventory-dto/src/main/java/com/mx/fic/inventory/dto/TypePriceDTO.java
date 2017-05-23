package com.mx.fic.inventory.dto;

public class TypePriceDTO implements BaseDTO{

	private static final long serialVersionUID = -6274354455764273730L;

	private Integer id;
	private String name;
	private String description;
	private StatusDTO statusDTO;
	private CompanyDTO companyDTO;
	
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
	public StatusDTO getStatusDTO() {
		return statusDTO;
	}
	public void setStatusDTO(StatusDTO statusDTO) {
		this.statusDTO = statusDTO;
	}
	public CompanyDTO getCompanyDTO() {
		return companyDTO;
	}
	public void setCompanyDTO(CompanyDTO companyDTO) {
		this.companyDTO = companyDTO;
	}

	public String toString() {
		return "TypePriceDTO [id=" + id + ", name=" + name + ", description=" + description + ", statusDTO=" + statusDTO
				+ ", companyDTO=" + companyDTO + "]";
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyDTO == null) ? 0 : companyDTO.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		TypePriceDTO other = (TypePriceDTO) obj;
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
