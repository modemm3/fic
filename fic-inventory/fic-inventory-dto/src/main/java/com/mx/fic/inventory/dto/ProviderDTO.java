package com.mx.fic.inventory.dto;

public class ProviderDTO implements BaseDTO {

	private static final long serialVersionUID = 7894117409133659900L;
	private Integer id;
	private String name;
	private String lastName;
	private String surName;
	private String reasonSocial;
	private String rfc;
	private String email;
	private Integer typePersonId;
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getReasonSocial() {
		return reasonSocial;
	}
	public void setReasonSocial(String reasonSocial) {
		this.reasonSocial = reasonSocial;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getTypePersonId() {
		return typePersonId;
	}
	public void setTypePersonId(Integer typePersonId) {
		this.typePersonId = typePersonId;
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
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProviderDTO [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", surName=");
		builder.append(surName);
		builder.append(", reasonSocial=");
		builder.append(reasonSocial);
		builder.append(", rfc=");
		builder.append(rfc);
		builder.append(", email=");
		builder.append(email);
		builder.append(", typePersonId=");
		builder.append(typePersonId);
		builder.append(", statusId=");
		builder.append(statusId);
		builder.append(", companyId=");
		builder.append(companyId);
		builder.append("]");
		return builder.toString();
	}

}
