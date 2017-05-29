package com.mx.fic.inventory.dto;

public class AddressDTO implements BaseDTO{

	private static final long serialVersionUID = -4192524577180876200L;
	private Integer id;
	private String street;
	private String colony;
	private Integer exteriorNumber;
	private Integer interiorNumber;
	private Integer postalCode;
	private String town;
	private String city;
	private String state;
	private Integer typeAddressId;
	private Integer statusId;
	private Integer companyId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getColony() {
		return colony;
	}
	public void setColony(String colony) {
		this.colony = colony;
	}
	public Integer getExteriorNumber() {
		return exteriorNumber;
	}
	public void setExteriorNumber(Integer exteriorNumber) {
		this.exteriorNumber = exteriorNumber;
	}
	public Integer getInteriorNumber() {
		return interiorNumber;
	}
	public void setInteriorNumber(Integer interiorNumber) {
		this.interiorNumber = interiorNumber;
	}
	public Integer getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getTypeAddressId() {
		return typeAddressId;
	}
	public void setTypeAddressId(Integer typeAddressId) {
		this.typeAddressId = typeAddressId;
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
