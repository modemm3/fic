package com.mx.fic.inventory.dto;

import java.sql.Timestamp;

public class SeasonDTO implements BaseDTO{

	private static final long serialVersionUID = -5704630289818695931L;
	private Integer id;
	private String name;
	private String description;
	private CompanyDTO companydto;
	private Timestamp startDate;
	private Timestamp endDate;
	
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
	public CompanyDTO getCompanydto() {
		return companydto;
	}
	public void setCompanydto(CompanyDTO companydto) {
		this.companydto = companydto;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	
}
