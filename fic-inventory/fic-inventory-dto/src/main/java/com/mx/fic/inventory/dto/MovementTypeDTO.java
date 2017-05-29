package com.mx.fic.inventory.dto;

public class MovementTypeDTO implements BaseDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3770771049611562485L;
	private Integer id;
	private String name;
	private String description;
	private Integer movementConceptId;
	private Integer statusId;
	private Integer companyId;
	
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
	public Integer getMovementConceptId() {
		return movementConceptId;
	}
	public void setMovementConceptId(Integer movementConceptId) {
		this.movementConceptId = movementConceptId;
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

}
