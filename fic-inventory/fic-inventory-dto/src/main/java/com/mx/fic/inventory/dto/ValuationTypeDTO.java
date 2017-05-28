package com.mx.fic.inventory.dto;

public class ValuationTypeDTO implements BaseDTO {

	private static final long serialVersionUID = -7964096648923165828L;

	private Integer id;
	private String name;
	private String description;
	private String keyValuation;
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
	public String getKeyValuation() {
		return keyValuation;
	}
	public void setKeyValuation(String keyValuation) {
		this.keyValuation = keyValuation;
	}
	public CompanyDTO getCompanyDTO() {
		return companyDTO;
	}
	public void setCompanyDTO(CompanyDTO companyDTO) {
		this.companyDTO = companyDTO;
	}
}
