package com.mx.fic.inventory.dto;

import java.sql.Timestamp;

public class CompanyDTO implements BaseDTO{

	private static final long serialVersionUID = -6918141828676112594L;
	
	private Integer id;
	private String name;
	private String reasonSocial;
	private String rfc;
	private String email;
	private StatusDTO statusDTO;
	private String contactName;
	private Timestamp creationDate;
	private Timestamp modifyDate;
	
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
	public StatusDTO getStatusDTO() {
		return statusDTO;
	}
	public void setStatusDTO(StatusDTO statusDTO) {
		this.statusDTO = statusDTO;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public String toString() {
		return "CompanyDTO [id=" + id + ", name=" + name + ", reasonSocial=" + reasonSocial + ", rfc=" + rfc
				+ ", email=" + email + ", statusDTO=" + statusDTO + ", contactName=" + contactName + ", creationDate="
				+ creationDate + ", modifyDate=" + modifyDate + "]";
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactName == null) ? 0 : contactName.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((reasonSocial == null) ? 0 : reasonSocial.hashCode());
		result = prime * result + ((rfc == null) ? 0 : rfc.hashCode());
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
		CompanyDTO other = (CompanyDTO) obj;
		if (contactName == null) {
			if (other.contactName != null)
				return false;
		} else if (!contactName.equals(other.contactName))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modifyDate == null) {
			if (other.modifyDate != null)
				return false;
		} else if (!modifyDate.equals(other.modifyDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reasonSocial == null) {
			if (other.reasonSocial != null)
				return false;
		} else if (!reasonSocial.equals(other.reasonSocial))
			return false;
		if (rfc == null) {
			if (other.rfc != null)
				return false;
		} else if (!rfc.equals(other.rfc))
			return false;
		if (statusDTO == null) {
			if (other.statusDTO != null)
				return false;
		} else if (!statusDTO.equals(other.statusDTO))
			return false;
		return true;
	}

}
