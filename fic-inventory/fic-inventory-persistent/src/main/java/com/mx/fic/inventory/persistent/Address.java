package com.mx.fic.inventory.persistent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name="address")
@NamedQueries({
	@NamedQuery(name="Address.getAllByCompany", query="select ad from Address ad where ad.company.id=:id")
})
public class Address implements BaseEntity  {

	private static final long serialVersionUID = 1462817466162350528L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	@Column(name ="street")
	private String street;
	@Column(name="colony")
	private String colony;
	@Column(name="exterior_number")
	private Integer exteriorNumber;
	@Column(name="interior_number")
	private Integer interiorNumber;
	@Column(name="postal_code")
	private Integer postalCode;
	@Column(name="town")
	private String town;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@JoinColumn(name="type_address_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private TypeAddress typeAddress;
	@JoinColumn(name="status_id", referencedColumnName="id")	
	@ManyToOne(fetch=FetchType.LAZY)
	private Status status;
	@JoinColumn(name="company_id", referencedColumnName="id")	
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
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
	public TypeAddress getTypeAddress() {
		return typeAddress;
	}
	public void setTypeAddress(TypeAddress typeAddress) {
		this.typeAddress = typeAddress;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", colony=" + colony + ", exteriorNumber=" + exteriorNumber
				+ ", interiorNumber=" + interiorNumber + ", postalCode=" + postalCode + ", town=" + town + ", city="
				+ city + ", state=" + state + ", typeAddress=" + typeAddress + ", status=" + status + ", company="
				+ company + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((colony == null) ? 0 : colony.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((exteriorNumber == null) ? 0 : exteriorNumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((interiorNumber == null) ? 0 : interiorNumber.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((town == null) ? 0 : town.hashCode());
		result = prime * result + ((typeAddress == null) ? 0 : typeAddress.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (colony == null) {
			if (other.colony != null)
				return false;
		} else if (!colony.equals(other.colony))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (exteriorNumber == null) {
			if (other.exteriorNumber != null)
				return false;
		} else if (!exteriorNumber.equals(other.exteriorNumber))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (interiorNumber == null) {
			if (other.interiorNumber != null)
				return false;
		} else if (!interiorNumber.equals(other.interiorNumber))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (town == null) {
			if (other.town != null)
				return false;
		} else if (!town.equals(other.town))
			return false;
		if (typeAddress == null) {
			if (other.typeAddress != null)
				return false;
		} else if (!typeAddress.equals(other.typeAddress))
			return false;
		return true;
	}

}
