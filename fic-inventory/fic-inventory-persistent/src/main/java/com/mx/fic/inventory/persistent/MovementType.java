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
@Table (name="movement_type")
@NamedQueries({
	@NamedQuery(name="MovementType.getAll", query = "select mt from MovementType mt")
})
public class MovementType implements BaseEntity {

	private static final long serialVersionUID = -7004668452945870833L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@JoinColumn(name="movement_concept_id", referencedColumnName="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private MovementConcept movementConcept;
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
	public MovementConcept getMovementConcept() {
		return movementConcept;
	}
	public void setMovementConcept(MovementConcept movementConcept) {
		this.movementConcept = movementConcept;
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
		return "MovementType [id=" + id + ", name=" + name + ", description=" + description + ", movementConcept="
				+ movementConcept + ", status=" + status + ", company=" + company + "]";
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((movementConcept == null) ? 0 : movementConcept.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovementType other = (MovementType) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
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
		if (movementConcept == null) {
			if (other.movementConcept != null)
				return false;
		} else if (!movementConcept.equals(other.movementConcept))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
}
